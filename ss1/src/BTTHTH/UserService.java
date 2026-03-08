package BTTHTH;

import java.io.FileNotFoundException;

public class UserService {

    public static String registerUser(String name, String ageInput, String email)
            throws InvalidAgeException, InvalidEmailException {

        int age;

        try {
            age = Integer.parseInt(ageInput);
        }
        catch (NumberFormatException e) {
            throw new NumberFormatException("Tuổi phải là một con số!");
        }

        if (age < 18) {
            throw new InvalidAgeException("Lỗi nghiệp vụ: Tuổi không đủ để đăng ký hệ thống.");
        }

        if (!email.contains("@")) {
            throw new InvalidEmailException("Lỗi nghiệp vụ: Email không hợp lệ.");
        }

        return "Name: " + name + ", Age: " + age + ", Email: " + email;
    }

    public static void saveUserToFile(String userData) throws FileNotFoundException {

        System.out.println("Đang lưu dữ liệu người dùng...");

        // giả lập lỗi hệ thống
        throw new FileNotFoundException("Không tìm thấy file lưu trữ.");

    }
}
