package bai2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateVitalSigns {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Nhập mã bệnh nhân:");
        String patientId = sc.nextLine();

        System.out.println("Nhập nhiệt độ cơ thể:");
        double temperature = Double.parseDouble(sc.nextLine());

        System.out.println("Nhập nhịp tim:");
        int heartRate = Integer.parseInt(sc.nextLine());

        String sql = "UPDATE patients SET temperature = ?, heart_rate = ? WHERE patient_id = ?";

        try (Connection con = DatabaseConnection.openConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            // gán tham số
            ps.setDouble(1, temperature);
            ps.setInt(2, heartRate);
            ps.setString(3, patientId);

            // thực thi
            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Cập nhật chỉ số sinh tồn thành công!");
            } else {
                System.out.println("Không tìm thấy bệnh nhân!");
            }

        } catch (SQLException e) {
            System.err.println("Lỗi: " + e.getMessage());
        }

        sc.close();
    }
}
/*
PHẦN 1 – PHÂN TÍCH

1. Vấn đề khi dùng Statement nối chuỗi
Khi sử dụng Statement và nối chuỗi để tạo câu lệnh SQL, dữ liệu nhập từ người dùng
sẽ được đưa trực tiếp vào câu SQL.

Ví dụ:
UPDATE patients SET temperature = " + temperature + ", heart_rate = " + heartRate

Nếu hệ điều hành dùng Locale như Pháp hoặc Việt Nam thì số thực có thể
được nhập là 37,5 (dùng dấu phẩy) thay vì 37.5 (dấu chấm).

Trong SQL, số thực phải dùng dấu chấm (37.5). Nếu truyền 37,5 thì câu lệnh SQL
sẽ bị lỗi cú pháp ngay lập tức.


2. Vì sao PreparedStatement giải quyết được vấn đề này

PreparedStatement sử dụng các phương thức truyền dữ liệu theo đúng kiểu dữ liệu,
ví dụ:

setDouble()
setInt()

Các phương thức này sẽ gửi dữ liệu đến Database dưới dạng giá trị số thực
hoặc số nguyên đúng chuẩn của JDBC, không phải dạng chuỗi.

Vì vậy lập trình viên không cần quan tâm đến việc hệ điều hành đang dùng
dấu chấm (.) hay dấu phẩy (,) cho số thực.


3. Lợi ích của việc sử dụng setDouble() và setInt()

- Đảm bảo dữ liệu đúng kiểu khi gửi tới database
- Không bị lỗi định dạng số theo Locale của hệ điều hành
- Tránh lỗi cú pháp SQL
- Code an toàn và ổn định hơn
*/
