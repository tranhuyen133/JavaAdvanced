package btth.util;

public class Main {
    public static void main(String[] args) {
        /**
         * Bài toán:
         * - Thực hiện chuyển từ Tùng -> Huyền 10tr
         * - Test case:
         *     + test đúng chuyển được
         *     + test sai có lỗi xảy ra trong quá trình giao dịch
         * */

// Mở kết nối
        Connection con = DataConnect.openConnect();
        try {

            // B1: Tắt autocommit
            con.setAutoCommit(false);
            // B2: Thực thi code
            // Trừ tiền tài khoản sender
            String sqlWithdraw = "UPDATE accounts SET balance = balance - ? WHERE id = ?";
            // Tạo transfer lịch sử
            String sqlTransfer = """
                    INSERT INTO transfers 
                    (sender_id,receive_id,amount,message,transfer_date) 
                    VALUE (?,?,?,?,?)
                    """;
            // Công tiền vào tài khoản receive
            String sqlDeposit = "UPDATE accounts SET balance = balance + ? WHERE id = ?";

            double amount = 9000000.0;
            int senderId = 1;
            int receiveId = 2;

            PreparedStatement preparedWithDraw = con.prepareStatement(sqlWithdraw);
            preparedWithDraw.setDouble(1, amount);
            preparedWithDraw.setInt(2, senderId);
            PreparedStatement preparedTransfer = con.prepareStatement(sqlTransfer);
            preparedTransfer.setInt(1, senderId);
            preparedTransfer.setInt(2, receiveId);
            preparedTransfer.setDouble(3, amount);
            preparedTransfer.setString(4, "Cầm lấy mà tiêu đi e, không phải nghĩ");
            preparedTransfer.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
            PreparedStatement preparedDeposit = con.prepareStatement(sqlDeposit);
            preparedDeposit.setDouble(1, amount);
            preparedDeposit.setInt(2, receiveId);

            preparedWithDraw.executeUpdate();
            preparedTransfer.executeUpdate();
            preparedDeposit.executeUpdate();

            // B3: Commit
            con.commit();
        } catch (SQLException e) {
            // B4: Rollback
            try {
                con.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            System.err.println(e.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
