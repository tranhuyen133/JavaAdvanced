package bai1;

import java.util.Map;

public class OrderCalculator {

    public double calculateTotal(Order order) {

        double total = 0;

        for (Map.Entry<Product, Integer> entry : order.getProducts().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();

            total += product.getPrice() * quantity;
        }

        System.out.println("Tổng tiền: " + total);

        return total;
    }
}
