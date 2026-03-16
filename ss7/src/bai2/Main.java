package bai2;

public class Main {

    public static void main(String[] args) {

        double totalAmount = 1000000;

        // Percentage Discount
        OrderCalculator calculator1 =
                new OrderCalculator(new PercentageDiscount(10));
        System.out.println("Số tiền sau giảm: " + calculator1.calculate(totalAmount));

        // Fixed Discount
        OrderCalculator calculator2 =
                new OrderCalculator(new FixedDiscount(50000));
        System.out.println("Số tiền sau giảm: " + calculator2.calculate(totalAmount));

        // No Discount
        OrderCalculator calculator3 =
                new OrderCalculator(new NoDiscount());
        System.out.println("Số tiền sau giảm: " + calculator3.calculate(totalAmount));

        // Holiday Discount (15%)
        OrderCalculator calculator4 =
                new OrderCalculator(new HolidayDiscount());
        System.out.println("Số tiền sau giảm: " + calculator4.calculate(totalAmount));
    }
}
