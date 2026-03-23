package bai3;

import btth.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class HandleGetSurgeryFee {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Nhập mã phẫu thuật:");
        int surgeryId = Integer.parseInt(sc.nextLine());

        try (Connection con = DatabaseConnection.openConnection()) {

            // tạo CallableStatement
            CallableStatement cstmt = con.prepareCall("{call GET_SURGERY_FEE(?, ?)}");

            // set tham số IN
            cstmt.setInt(1, surgeryId);

            // đăng ký tham số OUT
            cstmt.registerOutParameter(2, Types.DECIMAL);

            // thực thi stored procedure
            cstmt.execute();

            // lấy giá trị OUT
            double totalCost = cstmt.getDouble(2);

            // in kết quả
            System.out.println("Chi phí phẫu thuật: " + totalCost);

        } catch (SQLException e) {
            System.err.println("Lỗi SQL: " + e.getMessage());
        }

        sc.close();
    }
}
/*
PHẦN 1 – PHÂN TÍCH

1. Vì sao phải gọi registerOutParameter() trước khi thực thi?

Khi gọi Stored Procedure có tham số OUT, JDBC cần biết trước kiểu dữ liệu
của tham số đầu ra để chuẩn bị bộ nhớ nhận giá trị trả về từ Database.

Phương thức registerOutParameter() giúp JDBC:
- Xác định vị trí của tham số OUT
- Xác định kiểu dữ liệu của giá trị sẽ trả về

Nếu không gọi registerOutParameter() trước khi execute(), JDBC sẽ không biết
phải nhận dữ liệu ở vị trí nào và kiểu dữ liệu gì, dẫn đến lỗi như:
"The column index is out of range" hoặc không lấy được giá trị trả về.


2. Kiểu DECIMAL trong SQL tương ứng kiểu nào trong Java?

Nếu tham số OUT trong Stored Procedure là kiểu DECIMAL trong SQL
thì trong Java phải đăng ký bằng hằng số:

Types.DECIMAL

Ví dụ:
callableStatement.registerOutParameter(2, Types.DECIMAL);


3. Quy trình gọi Stored Procedure có OUT parameter

Bước 1: Mở kết nối Database
Bước 2: Tạo CallableStatement với câu lệnh CALL
Bước 3: Set giá trị cho tham số IN
Bước 4: registerOutParameter cho tham số OUT
Bước 5: execute()
Bước 6: Lấy giá trị OUT bằng getXxx()
*/