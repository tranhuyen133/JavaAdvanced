import java.util.Scanner;

public class ProductFactory {

    public static Product createProduct(int type, Scanner sc) {
        if(type != 1 || type != 2 ){
            System.out.print("Nhập sai bị trùng sản phẩm ");
            return null ;
        }
        System.out.print("Nhập ID: ");
        String id = sc.next();

        System.out.print("Nhập tên: ");
        String name = sc.next();

        System.out.print("Nhập giá: ");
        double price = sc.nextDouble();

        if (type == 1) {
            System.out.print("Nhập trọng lượng: ");
            double weight = sc.nextDouble();
            return new PhysicalProduct(id, name, price, weight);
        } else {
            System.out.print("Nhập dung lượng (MB): ");
            double size = sc.nextDouble();
            return new DigitalProduct(id, name, price, size);
        }
    }
}