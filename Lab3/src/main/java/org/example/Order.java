package org.example;

public class Order {
    private final int orderId;
    private final String status;

    public Order(int orderId) {
        this.orderId = orderId;
        this.status = "In Progress";
    }

    public int getOrderId() {
        return orderId;
    }

    public String getStatus() {
        return status;
    }

}