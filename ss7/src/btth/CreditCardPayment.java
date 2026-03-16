package btth;

public class CreditCardPayment implements PaymentStrategy {

    @Override
    public void pay(Order order) {
        System.out.println("Đang kết nối API ngân hàng... Thanh toán bằng Credit Card.");
    }

}