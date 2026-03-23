package bai1;
import btth.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DoctorLogin {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Nhập mã bác sĩ:");
        String doctorCode = sc.nextLine();

        System.out.println("Nhập mật khẩu:");
        String password = sc.nextLine();

        String sql = "SELECT * FROM doctors WHERE doctor_code = ? AND password = ?";

        try (Connection con = DatabaseConnection.openConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            // Gán giá trị vào tham số
            ps.setString(1, doctorCode);
            ps.setString(2, password);

            // Thực thi truy vấn
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Đăng nhập thành công!");
            } else {
                System.out.println("Sai mã bác sĩ hoặc mật khẩu!");
            }

        } catch (SQLException e) {
            System.err.println("Lỗi: " + e.getMessage());
        }

        sc.close();
    }
}
/*
PHẦN 1 – PHÂN TÍCH

1. SQL Injection là gì?
SQL Injection là một lỗ hổng bảo mật xảy ra khi dữ liệu người dùng được nối trực tiếp
vào câu lệnh SQL. Khi đó kẻ tấn công có thể chèn thêm các đoạn SQL độc hại để thay
đổi logic truy vấn của hệ thống.

Ví dụ nếu viết câu SQL bằng cách nối chuỗi:
SELECT * FROM doctors WHERE doctor_code = '" + code + "' AND password = '" + password + "'

Nếu người dùng nhập mật khẩu:
' OR '1'='1

Thì câu SQL thực tế sẽ trở thành:
SELECT * FROM doctors WHERE doctor_code = 'A01' AND password = '' OR '1'='1'

Điều kiện '1'='1' luôn đúng nên hệ thống sẽ cho phép đăng nhập trái phép.


2. Vì sao PreparedStatement chống được SQL Injection?
PreparedStatement giúp chống SQL Injection vì nó tách biệt câu lệnh SQL và dữ liệu
đầu vào của người dùng.

Câu lệnh SQL sẽ được viết với các dấu ? thay cho tham số:
SELECT * FROM doctors WHERE doctor_code = ? AND password = ?

Sau đó dữ liệu người dùng được truyền vào bằng các phương thức như:
setString(), setInt()...

Database sẽ coi dữ liệu này chỉ là giá trị thuần túy, không phải là một phần của câu
lệnh SQL nên không thể chèn thêm điều kiện độc hại.


3. Cơ chế Pre-compiled (biên dịch trước)
PreparedStatement sử dụng cơ chế pre-compiled nghĩa là câu lệnh SQL được
database biên dịch trước khi truyền dữ liệu vào.

Quy trình:
Bước 1: Database nhận câu lệnh SQL chứa dấu ?
Bước 2: Database phân tích và biên dịch cấu trúc SQL
Bước 3: Sau đó dữ liệu được truyền vào các vị trí ?

Vì cấu trúc SQL đã được cố định từ trước nên dữ liệu người dùng không thể thay đổi
logic của câu lệnh SQL.

Nhờ đó PreparedStatement giúp:
- Ngăn chặn SQL Injection
- Tăng hiệu năng khi thực thi nhiều lần
*/