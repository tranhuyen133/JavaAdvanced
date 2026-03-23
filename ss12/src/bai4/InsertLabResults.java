package bai4;

import btth.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertLabResults {

    public static void main(String[] args) {

        try (Connection con = DatabaseConnection.openConnection()) {

            String sql = "INSERT INTO lab_results(patient_id, test_result) VALUES (?, ?)";

            // tạo PreparedStatement 1 lần duy nhất
            PreparedStatement ps = con.prepareStatement(sql);

            for (int i = 0; i < 1000; i++) {

                String patientId = "P" + i;
                double result = 5.0 + i;

                // truyền tham số
                ps.setString(1, patientId);
                ps.setDouble(2, result);

                // thực thi
                ps.executeUpdate();
            }

            System.out.println("Đã nạp dữ liệu xét nghiệm thành công!");

        } catch (SQLException e) {
            System.err.println("Lỗi SQL: " + e.getMessage());
        }
    }
}
