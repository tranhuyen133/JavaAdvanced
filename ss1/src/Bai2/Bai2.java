package Bai2;

import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập tổng số người dùng: ");
        int tongNguoi = scanner.nextInt();

        System.out.print("Nhập số nhóm muốn chia: ");
        int soNhom = scanner.nextInt();

        try {
            int moiNhom = tongNguoi / soNhom;
            System.out.println("Mỗi nhóm có: " + moiNhom + " người.");
        }
        catch (ArithmeticException e) {
            System.out.println("Không thể chia cho 0!");
        }

        System.out.println("Chương trình vẫn tiếp tục chạy...");
        scanner.close();
    }
}