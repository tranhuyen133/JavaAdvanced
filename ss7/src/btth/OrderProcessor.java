package btth;

public class OrderProcessor {

    private Database database;
    private EmailSender emailSender;
    private PaymentStrategy paymentStrategy;

    public OrderProcessor(Database database, EmailSender emailSender, PaymentStrategy paymentStrategy) {
        this.database = database;
        this.emailSender = emailSender;
        this.paymentStrategy = paymentStrategy;
    }

    public void processOrder(Order order) {

        // 1. Lưu vào database
        database.save(order);

        // 2. Thanh toán
        paymentStrategy.pay(order);

        // 3. Gửi email
        emailSender.sendEmail(
                order.getCustomerEmail(),
                "Đơn hàng của bạn đã được xử lý thành công!"
        );
    }
}
}
