package Bai4;

import java.io.IOException;

public class Bai4 {

    // Method C: nơi phát sinh lỗi
    public static void saveToFile() throws IOException {
        System.out.println("Đang lưu dữ liệu vào file...");

        // Giả lập lỗi khi ghi file
        throw new IOException("Lỗi khi ghi file!");
    }

    // Method B: gọi Method C và chuyển tiếp lỗi
    public static void processUserData() throws IOException {
        System.out.println("Đang xử lý dữ liệu người dùng...");
        saveToFile();
    }

    // Method A: điểm chặn cuối
    public static void main(String[] args) {

        try {
            processUserData();
        }
        catch (IOException e) {
            System.out.println("Đã xảy ra lỗi khi lưu dữ liệu: " + e.getMessage());
        }

        System.out.println("Chương trình vẫn tiếp tục chạy...");
    }
}
