package bai4;

import bai1.DBContext;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PatientSearch {

    // Hàm kiểm tra và loại bỏ ký tự nguy hiểm
    public static String sanitizeInput(String input) {

        if (input == null) {
            return "";
        }

        // loại bỏ các ký tự nguy hiểm
        input = input.replace("'", "");
        input = input.replace(";", "");
        input = input.replace("--", "");

        return input;
    }

    public void searchPatientByName(String name) {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {

            conn = DBContext.getConnection();

            // làm sạch dữ liệu đầu vào
            String safeName = sanitizeInput(name);

            String sql = "SELECT * FROM patients WHERE name = '" + safeName + "'";

            st = conn.createStatement();

            rs = st.executeQuery(sql);

            while (rs.next()) {

                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Age: " + rs.getInt("age"));
                System.out.println("Disease: " + rs.getString("disease"));
                System.out.println("-----------------------");
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
                if (st != null) st.close();
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

    // test
    public static void main(String[] args) {

        PatientSearch ps = new PatientSearch();

        ps.searchPatientByName("Nguyen Van A");
        ps.searchPatientByName("' OR '1'='1");
    }
}
