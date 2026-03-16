package bai1;

import java.util.*;

public class Order {

    private String orderId;
    private Customer customer;
    private Map<Product, Integer> products = new HashMap<>();

    public Order(String orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        System.out.println("Đơn hàng " + orderId + " được tạo");
    }

    public void addProduct(Product product, int quantity) {
        products.put(product, quantity);
        System.out.println("Đã thêm sản phẩm " + product.getId());
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public String getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }
}
