package bai2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Thiết bị
        Light light = new Light();
        Fan fan = new Fan();
        AirConditioner ac = new AirConditioner();

        // Adapter
        OldThermometer oldThermometer = new OldThermometer();
        TemperatureSensor sensor =
                new ThermometerAdapter(oldThermometer);

        // Facade
        SmartHomeFacade facade =
                new SmartHomeFacade(light, fan, ac, sensor);

        while (true) {
            System.out.println("\n1. Xem nhiệt độ");
            System.out.println("2. Rời nhà");
            System.out.println("3. Chế độ ngủ");
            System.out.println("0. Thoát");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    facade.getCurrentTemperature();
                    break;

                case 2:
                    facade.leaveHome();
                    break;

                case 3:
                    facade.sleepMode();
                    break;

                case 0:
                    System.exit(0);
            }
        }
    }
}
