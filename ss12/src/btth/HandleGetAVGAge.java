package btth;

import btth.util.DatabaseConnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class HandleGetAVGAge {

    public static void main(String[] args) {

        // B1: Mở kết nối tới database
        try (Connection con = DatabaseConnection.openConnection()) {

            // B2: Tạo câu lệnh gọi Stored Procedure
            String sql = "{CALL proc_get_avg_age_doctor(?)}";

            // B3: Tạo đối tượng CallableStatement
            CallableStatement callableStatement = con.prepareCall(sql);

            // B4: Đăng ký tham số OUT
            callableStatement.registerOutParameter(1, Types.DOUBLE);

            // B5: Thực thi thủ tục
            callableStatement.execute();

            // B6: Lấy giá trị OUT từ Stored Procedure
            double avgAge = callableStatement.getDouble(1);

            // B7: Hiển thị kết quả
            System.out.println("Tuổi trung bình của bác sĩ: " + avgAge);

        } catch (SQLException e) {
            System.err.println("Lỗi SQL: " + e.getMessage());
        }
    }
}