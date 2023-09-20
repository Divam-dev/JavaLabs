package org.example;

import java.util.List;

public class Order {
    private final int orderId;
    private final String status;
    private final List<Product> products;


    public Order(int orderId, List<Product> products) {
        this.orderId = orderId;
        this.status = "In Progress";
        this.products = products;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getStatus() {
        return status;
    }

    public List<Product> getProducts() {
        return products;
    }
}