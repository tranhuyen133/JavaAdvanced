package btth;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        PatientManagement pm = new PatientManagement();
        Scanner sc = new Scanner(System.in);

        int choice;

        do {

            System.out.println("\n===== HỆ THỐNG QUẢN LÝ BỆNH NHÂN =====");
            System.out.println("1. Xem danh sách bệnh nhân");
            System.out.println("2. Thêm bệnh nhân");
            System.out.println("3. Xóa bệnh nhân");
            System.out.println("4. Thoát");
            System.out.print("Chọn chức năng: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    pm.displayAllPatients();
                    break;

                case 2:
                    System.out.print("Nhập tên bệnh nhân: ");
                    String name = sc.nextLine();

                    System.out.print("Nhập tuổi: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nhập chẩn đoán: ");
                    String diagnosis = sc.nextLine();

                    pm.addPatient(name, age, diagnosis);
                    break;

                case 3:
                    System.out.print("Nhập ID cần xóa: ");
                    int id = sc.nextInt();
                    pm.deletePatient(id);
                    break;

                case 4:
                    System.out.println("Thoát hệ thống...");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }

        } while (choice != 4);

        sc.close();
    }
}
