package btth;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PatientManagement {

    // Cấu hình database
    private static final String URL = "jdbc:mysql://localhost:3306/Hospital_DB";
    private static final String USER = "root";
    private static final String PASS = "123456";

    // Phương thức kết nối database
    public Connection getConnection() {

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Kết nối hệ thống y tế thành công!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

    // Hiển thị danh sách bệnh nhân
    public void displayAllPatients() {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {

            conn = getConnection();
            stmt = conn.createStatement();

            String sql = "SELECT * FROM Patients";

            rs = stmt.executeQuery(sql);

            System.out.println("===== DANH SÁCH BỆNH NHÂN =====");

            while (rs.next()) {

                int id = rs.getInt("patient_id");
                String name = rs.getString("full_name");
                int age = rs.getInt("age");
                String diagnosis = rs.getString("diagnosis");

                System.out.println(id + " | " + name + " | " + age + " | " + diagnosis);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            try {
                if (rs != null) rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Thêm bệnh nhân
    public void addPatient(String name, int age, String desc) {

        Connection conn = null;
        Statement stmt = null;

        try {

            conn = getConnection();
            stmt = conn.createStatement();

            String sql = "INSERT INTO Patients(full_name, age, diagnosis) VALUES ('"
                    + name + "', " + age + ", '" + desc + "')";

            int rows = stmt.executeUpdate(sql);

            if (rows > 0) {
                System.out.println("Đã thêm hồ sơ bệnh nhân thành công.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            try {
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Xóa bệnh nhân
    public void deletePatient(int id) {

        Connection conn = null;
        Statement stmt = null;

        try {

            conn = getConnection();
            stmt = conn.createStatement();

            String sql = "DELETE FROM Patients WHERE patient_id = " + id;

            int rows = stmt.executeUpdate(sql);

            if (rows > 0) {
                System.out.println("Đã xóa " + rows + " hồ sơ khỏi hệ thống.");
            } else {
                System.out.println("Không tìm thấy bệnh nhân.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            try {
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}