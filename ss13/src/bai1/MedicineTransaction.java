package bai1;

import java.sql.*;

public class MedicineTransaction {

    public static void dispenseMedicine(int medicineId, int patientId) {

        Connection conn = null;

        try {

            conn = DBConnection.getConnection();

            // Tắt AutoCommit
            conn.setAutoCommit(false);

            // 1. Trừ thuốc trong kho
            String updateInventory =
                    "UPDATE Medicine_Inventory SET quantity = quantity - 1 WHERE medicine_id = ?";

            PreparedStatement ps1 = conn.prepareStatement(updateInventory);
            ps1.setInt(1, medicineId);
            ps1.executeUpdate();

            // 2. Lưu lịch sử kê đơn
            String insertPrescription =
                    "INSERT INTO Prescription_History(patient_id, medicine_id, created_date) VALUES (?, ?, NOW())";

            PreparedStatement ps2 = conn.prepareStatement(insertPrescription);
            ps2.setInt(1, patientId);
            ps2.setInt(2, medicineId);
            ps2.executeUpdate();

            // Commit nếu mọi thứ OK
            conn.commit();

            System.out.println("Cấp phát thuốc thành công");

        } catch (Exception e) {

            try {
                if (conn != null) {
                    conn.rollback(); // hủy toàn bộ nếu lỗi
                    System.out.println("Lỗi xảy ra → Rollback Transaction");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            e.printStackTrace();

        } finally {

            try {
                if (conn != null) {
                    conn.setAutoCommit(true);
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
}
//phần 1
/*
Phân tích lỗi:

Trong JDBC, mặc định Connection hoạt động ở chế độ AutoCommit = true.
Điều này có nghĩa là sau mỗi câu lệnh SQL được thực thi (executeUpdate),
hệ thống sẽ tự động commit dữ liệu ngay lập tức.

Trong đoạn code của Junior, câu lệnh trừ thuốc trong kho được thực hiện trước
và được commit ngay sau khi chạy xong. Nếu sau đó xảy ra lỗi mạng hoặc lỗi SQL
ở câu lệnh lưu lịch sử kê đơn (Prescription_History), thì câu lệnh thứ hai sẽ thất bại
nhưng dữ liệu của câu lệnh đầu tiên đã được lưu vào database.

Kết quả là kho thuốc đã bị trừ nhưng không có bản ghi trong lịch sử kê đơn,
gây sai lệch dữ liệu. Điều này xảy ra vì hai thao tác không được đặt trong
cùng một Transaction, vi phạm nguyên lý Atomicity (All-or-Nothing) của ACID.
*/
