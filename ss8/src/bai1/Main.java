package bai1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Device> devices = new ArrayList<>();

        HardwareConnection connection = HardwareConnection.getInstance();
        boolean isConnected = false;

        while (true) {
            System.out.println("\n1. Kết nối phần cứng");
            System.out.println("2. Tạo thiết bị");
            System.out.println("3. Bật thiết bị");
            System.out.println("4. Tắt thiết bị");
            System.out.println("0. Thoát");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    if (!isConnected) {
                        connection.connect();
                        isConnected = true;
                    } else {
                        System.out.println("Đã kết nối trước đó (Singleton).");
                    }
                    break;

                case 2:
                    System.out.println("Chọn loại: 1. Đèn 2. Quạt 3. Điều hòa");
                    int type = sc.nextInt();

                    DeviceFactory factory = null;

                    if (type == 1) factory = new LightFactory();
                    else if (type == 2) factory = new FanFactory();
                    else if (type == 3) factory = new AirConditionerFactory();

                    if (factory != null) {
                        Device device = factory.createDevice();
                        devices.add(device);
                    }
                    break;

                case 3:
                    System.out.println("Chọn thiết bị:");
                    for (int i = 0; i < devices.size(); i++) {
                        System.out.println(i + ". Device " + i);
                    }
                    int onIndex = sc.nextInt();
                    devices.get(onIndex).turnOn();
                    break;

                case 4:
                    System.out.println("Chọn thiết bị:");
                    for (int i = 0; i < devices.size(); i++) {
                        System.out.println(i + ". Device " + i);
                    }
                    int offIndex = sc.nextInt();
                    devices.get(offIndex).turnOff();
                    break;

                case 0:
                    System.exit(0);
            }
        }
    }
}
