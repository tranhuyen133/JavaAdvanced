import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ProductDatabase db = ProductDatabase.getInstance();

        while (true) {
            System.out.println("\n----- QUẢN LÝ SẢN PHẨM -----");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Xem danh sách");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xoá");
            System.out.println("5. Thoát");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("1. Physical | 2. Digital");
                    int type = sc.nextInt();
                    Product p = ProductFactory.createProduct(type, sc);
                    db.addProduct(p);
                    break;

                case 2:
                    List<Product> list = db.getAllProducts();
                    if (list.isEmpty()) {
                        System.out.println("Danh sách rỗng");
                    } else {
                        for (Product pr : list) {
                            pr.displayInfo();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Nhập ID cần sửa: ");
                    String idUpdate = sc.next();
                    Product pu = db.findById(idUpdate);

                    if (pu != null) {
                        System.out.print("Tên mới: ");
                        pu.setName(sc.next());
                        System.out.print("Giá mới: ");
                        pu.setPrice(sc.nextDouble());

                        if (pu instanceof PhysicalProduct) {
                            System.out.print("Weight mới: ");
                            ((PhysicalProduct) pu).setWeight(sc.nextDouble());
                        } else {
                            System.out.print("Size mới: ");
                            ((DigitalProduct) pu).setSize(sc.nextDouble());
                        }

                    } else {
                        System.out.println("Không tìm thấy!");
                    }
                    break;

                case 4:
                    System.out.print("Nhập ID cần xoá: ");
                    String idDelete = sc.next();
                    db.deleteProduct(idDelete);
                    break;

                case 5:
                    System.exit(0);
            }
        }
    }
}