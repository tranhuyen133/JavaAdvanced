package bai2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class bai2 {

    // =========================
    // 1. Database configuration
    // =========================
    // Sử dụng hằng số để lưu cấu hình database
    // giúp tránh lặp lại code và dễ thay đổi khi deploy
    private static final String DB_URL = "jdbc:mysql://localhost:3306/Hospital_DB";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    // =========================
    // 2. Create connection
    // =========================
    // Phương thức tạo kết nối đến database
    // các phương thức khác chỉ cần gọi lại hàm này
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }

    // =========================
    // 3. Query patient by ID
    // =========================
    public void getPatientById(int patientId) {

        // Khai báo tài nguyên JDBC
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // Tạo kết nối database
            conn = getConnection();

            // Câu truy vấn SQL sử dụng placeholder (?) để tránh SQL Injection
            String sql = "SELECT * FROM patients WHERE id = ?";

            // Tạo PreparedStatement
            ps = conn.prepareStatement(sql);

            // Gán giá trị cho placeholder
            ps.setInt(1, patientId);

            // Thực thi truy vấn
            rs = ps.executeQuery();

            // Lặp qua kết quả trả về
            while (rs.next()) {

                // Lấy dữ liệu từ ResultSet
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String disease = rs.getString("disease");

                // Hiển thị thông tin bệnh nhân
                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
                System.out.println("Disease: " + disease);
                System.out.println("------------------------");
            }

        } catch (SQLException e) {

            // Xử lý lỗi khi truy vấn database
            e.printStackTrace();

        } finally {

            // =====================================
            // 4. Đóng tài nguyên để tránh rò rỉ
            // =====================================
            // Đóng theo thứ tự:
            // ResultSet -> PreparedStatement -> Connection

            try {
                if (rs != null) {
                    rs.close(); // đóng ResultSet
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (ps != null) {
                    ps.close(); // đóng PreparedStatement
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (conn != null) {
                    conn.close(); // đóng Connection
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // =========================
    // 5. Main method for testing
    // =========================
    public static void main(String[] args) {

        // Tạo đối tượng DBContext
        DBContext db = new DBContext();

        // Gọi phương thức truy vấn bệnh nhân
        db.getPatientById(1);
    }
}
