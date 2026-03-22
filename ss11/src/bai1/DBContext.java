package bai1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBContext {

    // Hằng số cấu hình database
    private static final String DB_URL = "jdbc:mysql://localhost:3306/Hospital_DB";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    // Phương thức tạo connection
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }

    // Truy vấn hồ sơ bệnh nhân theo ID
    public void getPatientById(int patientId) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();

            String sql = "SELECT * FROM patients WHERE id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, patientId);

            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String disease = rs.getString("disease");

                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
                System.out.println("Disease: " + disease);
                System.out.println("---------------------");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            // Đóng ResultSet
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            // Đóng PreparedStatement
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            // Đóng Connection
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Test chạy thử
    public static void main(String[] args) {
        DBContext db = new DBContext();
        db.getPatientById(1);
    }
}
