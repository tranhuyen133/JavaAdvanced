package btth;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Tạo Scanner để nhập dữ liệu từ bàn phím
        Scanner sc = new Scanner(System.in);

        // Bước 1: Mở kết nối đến database
        try (Connection con = DatabaseConnection.openConnection()) {

            // Bước 2: Câu lệnh SQL thêm dữ liệu vào bảng doctors
            String sql = "INSERT INTO doctors VALUES (?, ?, ?, ?, ?)";

            // Bước 3: Tạo đối tượng PreparedStatement
            PreparedStatement preparedStatement = con.prepareStatement(sql);

            // Thêm 2 bác sĩ vào database
            for (int i = 0; i < 2; i++) {
            // b4: set parameter(thamn số vào)
                System.out.println("Nhập mã bác sĩ:");
                preparedStatement.setString(1, sc.nextLine());

                System.out.println("Nhập tên bác sĩ:");
                preparedStatement.setString(2, sc.nextLine());

                System.out.println("Nhập giới tính bác sĩ:");
                preparedStatement.setString(3, sc.nextLine());

                System.out.println("Nhập tuổi bác sĩ:");
                preparedStatement.setInt(4, Integer.parseInt(sc.nextLine()));

                System.out.println("Nhập khoa bác sĩ:");
                preparedStatement.setString(5, sc.nextLine());

                // Bước 5: Thực thi câu lệnh SQL
                int rows = preparedStatement.executeUpdate();

                System.out.println("Số bản ghi đã thêm: " + rows);

                // Xóa tham số để chuẩn bị cho lần insert tiếp theo
                preparedStatement.clearParameters();
            }

        } catch (SQLException e) {
            // Xử lý lỗi SQL
            System.err.println("Lỗi SQL: " + e.getMessage());
        }

        // Đóng Scanner
        sc.close();
    }
}