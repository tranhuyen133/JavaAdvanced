package bai3;

public class Main {

    public static void main(String[] args) {

        // COD
        PaymentProcessor processor1 =
                new PaymentProcessor(new CODPayment());
        processor1.process(500000);

        // Credit Card
        PaymentProcessor processor2 =
                new PaymentProcessor(new CreditCardPayment());
        processor2.process(1000000);

        // MoMo
        PaymentProcessor processor3 =
                new PaymentProcessor(new MomoPayment());
        processor3.process(750000);

        // Kiểm tra LSP
        PaymentMethod method;

        method = new CreditCardPayment();
        PaymentProcessor processor4 = new PaymentProcessor(method);
        processor4.process(1000000);

        method = new MomoPayment(); // thay thế implementation
        PaymentProcessor processor5 = new PaymentProcessor(method);
        processor5.process(750000);
    }
}