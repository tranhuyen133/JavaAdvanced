package BTTHTH;

import java.util.Scanner;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {

            System.out.print("Nhập tên: ");
            String name = scanner.nextLine();

            System.out.print("Nhập tuổi: ");
            String ageInput = scanner.nextLine();

            System.out.print("Nhập email: ");
            String email = scanner.nextLine();

            String userData = UserService.registerUser(name, ageInput, email);

            System.out.println("Đăng ký thành công!");
            System.out.println(userData);

            UserService.saveUserToFile(userData);

        }
        catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }
        catch (InvalidEmailException e) {
            System.out.println(e.getMessage());
        }
        catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        catch (FileNotFoundException e) {
            System.out.println("Lỗi hệ thống: " + e.getMessage());
        }
        finally {
            System.out.println("Hoàn tất luồng xử lý đăng ký.");
            scanner.close();
        }

    }
}
