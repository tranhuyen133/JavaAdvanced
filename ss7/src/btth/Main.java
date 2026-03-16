package btth;

public class Main {

    public static void main(String[] args) {

        Order order = new Order("customer@gmail.com");

        Database database = new Database();
        EmailSender emailSender = new EmailSender();

        PaymentStrategy payment = new CreditCardPayment();
        // PaymentStrategy payment = new PayPalPayment();

        OrderProcessor processor =
                new OrderProcessor(database, emailSender, payment);

        processor.processOrder(order);

    }
}
