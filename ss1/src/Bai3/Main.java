package Bai3;

public class Main {
    public static void main(String[] args) {

        User user = new User();

        try {
            user.setAge(-5);
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Chương trình vẫn tiếp tục chạy...");
    }
}