package org.example.Lab7;

import java.util.Map;

public class Order {
    private final Integer id;
    private final Integer userId;
    private final Map<Product, Integer> orderDetails;
    private final double totalPrice;

    public Order(Integer id, Integer userId, Map<Product, Integer> orderDetails, double totalPrice) {
        this.id = id;
        this.userId = userId;
        this.orderDetails = orderDetails;
        this.totalPrice = totalPrice;
    }

    public Integer getId() {
        return id;
    }

    public Integer getUserId() {
        return userId;
    }

    public Map<Product, Integer> getOrderDetails() {
        return orderDetails;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

}
