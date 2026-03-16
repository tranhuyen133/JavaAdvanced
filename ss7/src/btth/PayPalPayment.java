package btth;

public class PayPalPayment implements PaymentStrategy {

    @Override
    public void pay(Order order) {
        System.out.println("Đang mở cổng PayPal... Thanh toán PayPal.");
    }

}