package bai1;

public class Main {

    public static void main(String[] args) {

        // Tạo sản phẩm
        Product p1 = new Product("SP01", "Laptop", 15000000);
        Product p2 = new Product("SP02", "Chuột", 300000);

        // Tạo khách hàng
        Customer customer = new Customer("Nguyễn Văn A", "a@example.com", "Hà Nội");

        // Tạo đơn hàng
        Order order = new Order("ORD001", customer);

        order.addProduct(p1, 1);
        order.addProduct(p2, 2);

        // Tính tổng tiền
        OrderCalculator calculator = new OrderCalculator();
        double total = calculator.calculateTotal(order);

        // Lưu đơn hàng
        OrderRepository repository = new OrderRepository();
        repository.save(order);

        // Gửi email
        EmailService emailService = new EmailService();
        emailService.sendEmail(
                customer.getEmail(),
                "Đơn hàng " + order.getOrderId() + " đã được tạo"
        );
    }
}