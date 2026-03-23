package btth;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class MainHandleDelete {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // B1: Nhập mã bác sĩ cần xoá
        System.out.println("Nhập vào mã bác sĩ muốn xoá:");
        String idDelete = sc.nextLine();

        // B2: Mở kết nối tới database
        try (Connection connection = DatabaseConnection.openConnection()) {

            // B3: Chuẩn bị câu lệnh gọi Stored Procedure
            String sql = "{CALL deleteDoctor(?)}";

            // B4: Tạo đối tượng CallableStatement
            CallableStatement callableStatement = connection.prepareCall(sql);

            // B5: Truyền tham số vào Stored Procedure
            callableStatement.setString(1, idDelete);

            // B6: Thực thi câu lệnh xoá
            int rows = callableStatement.executeUpdate();

            // B7: Kiểm tra kết quả
            if (rows > 0) {
                System.out.println("Xoá bác sĩ thành công!");
            } else {
                System.out.println("Không tìm thấy bác sĩ để xoá!");
            }

        } catch (SQLException e) {
            System.err.println("Lỗi SQL: " + e.getMessage());
        }

        // Đóng Scanner
        sc.close();
    }
}