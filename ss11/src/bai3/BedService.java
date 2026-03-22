package bai3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BedService {

    public void updateBedStatus(String bedId) {

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DBContext.getConnection();

            String sql = "UPDATE beds SET bed_status = 'Đang sử dụng' WHERE bed_id = ?";

            ps = conn.prepareStatement(sql);
            ps.setString(1, bedId);

            // executeUpdate trả về số dòng bị ảnh hưởng
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Cập nhật trạng thái giường thành công.");
            } else {
                System.out.println("Lỗi: Mã giường không tồn tại.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            try {
                if (ps != null) ps.close();
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

    // Test
    public static void main(String[] args) {
        BedService service = new BedService();

        service.updateBedStatus("Bed_001"); // tồn tại
        service.updateBedStatus("Bed_999"); // không tồn tại
    }
}
