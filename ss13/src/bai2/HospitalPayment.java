package bai2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HospitalPayment {

    public static void payInvoice(int patientId, int invoiceId, double amount) {

        Connection conn = null;

        try {
            conn = DBConnection.getConnection();

            // Bắt đầu transaction
            conn.setAutoCommit(false);

            // 1. Trừ tiền ví bệnh nhân
            String sql1 = "UPDATE Patient_Wallet SET balance = balance - ? WHERE patient_id = ?";
            PreparedStatement ps1 = conn.prepareStatement(sql1);
            ps1.setDouble(1, amount);
            ps1.setInt(2, patientId);
            ps1.executeUpdate();

            // 2. Cập nhật trạng thái hóa đơn
            String sql2 = "UPDATE Invoices SET status = 'Đã thanh toán' WHERE invoice_id = ?";
            PreparedStatement ps2 = conn.prepareStatement(sql2);
            ps2.setInt(1, invoiceId);
            ps2.executeUpdate();

            // Nếu cả 2 bước thành công → commit
            conn.commit();

            System.out.println("Thanh toán thành công!");

        } catch (Exception e) {

            // Nếu có lỗi → rollback
            try {
                if (conn != null) {
                    conn.rollback();
                    System.out.println("Có lỗi xảy ra → Rollback Transaction!");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            e.printStackTrace();

        } finally {

            // Đóng kết nối
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

    public static void main(String[] args) {

        // Test thanh toán
        payInvoice(101, 1001, 500000);

    }
}
/*
Phân tích vấn đề:

Trong hệ thống thanh toán viện phí, hai thao tác gồm trừ tiền ví bệnh nhân
(Patient_Wallet) và cập nhật trạng thái hóa đơn (Invoices) phải nằm trong
cùng một Transaction để đảm bảo nguyên lý Atomicity (All-or-Nothing).

Trong đoạn code hiện tại, lập trình viên đã tắt AutoCommit và gọi commit()
khi giao dịch thành công. Tuy nhiên khi xảy ra lỗi ở bước cập nhật hóa đơn
(ví dụ sai tên bảng hoặc lỗi truy vấn), chương trình sẽ ném Exception và
dừng trước khi commit() được thực hiện.

Nếu không có lệnh rollback(), transaction sẽ vẫn tồn tại trên connection
và không được kết thúc một cách rõ ràng. Điều này khiến kết nối cơ sở dữ liệu
bị treo, giữ lock và chiếm tài nguyên hệ thống, có thể ảnh hưởng tới các
giao dịch khác.

Do đó khi xảy ra lỗi trong transaction, cần gọi conn.rollback() trong
khối catch để hủy toàn bộ thay đổi và giải phóng tài nguyên database.
*/