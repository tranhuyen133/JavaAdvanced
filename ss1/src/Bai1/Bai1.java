package Bai1;

import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhập năm sinh của bạn: ");
            String namSinhStr = scanner.nextLine();

            int namSinh = Integer.parseInt(namSinhStr);

            int namHienTai = 2026;
            int tuoi = namHienTai - namSinh;

            System.out.println("Tuổi của bạn là: " + tuoi);
        }
        catch (NumberFormatException e) {
            System.out.println("Lỗi: Vui lòng nhập năm sinh bằng số (ví dụ: 2000).");
        }
        finally {
            scanner.close();
            System.out.println("Thực hiện dọn dẹp tài nguyên trong finally...");
        }
    }
}
