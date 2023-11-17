package org.example.Lab7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ECommercePlatform {
    private final Map<Integer, User> users;
    private final Map<Integer, Product> products;
    private final Map<Integer, Order> orders;

    public ECommercePlatform() {
        this.users = new HashMap<>();
        this.products = new HashMap<>();
        this.orders = new HashMap<>();
    }

    public void addUser(User user) {
        if (!users.containsKey(user.getId())) {
            users.put(user.getId(), user);
        } else {
            throw new IllegalArgumentException("User with ID " + user.getId() + " already exists.");
        }
    }

    public void addProduct(Product product) {
        if (!products.containsKey(product.getId())) {
            products.put(product.getId(), product);
        } else {
            throw new IllegalArgumentException("Product with ID " + product.getId() + " already exists.");
        }
    }

    public void createOrder(Integer userId, Map<Product, Integer> orderDetails) {
        double totalPrice = orderDetails.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();

        Order order = new Order(orders.size() + 1, userId, orderDetails, totalPrice);
        orders.put(order.getId(), order);

        orderDetails.forEach((product, quantity) -> {
            int originalStock = product.getStock();

            if (originalStock >= quantity) {
                int remainingStock = originalStock - quantity;
                product.setStock(remainingStock);
            } else {
                System.out.println("Error: Insufficient stock" + product.getName());
            }
        });
    }


    public List<Product> listAvailableProducts() {
        return products.values().stream()
                .filter(product -> product.getStock() > 0)
                .toList();
    }

    public List<User> listUsers() {
        return new ArrayList<>(users.values());
    }

    public List<Order> listOrders() {
        return new ArrayList<>(orders.values());
    }

    public void updateStock(Integer productId, int newStock) {
        Product product = products.get(productId);
        if (product != null) {
            product.setStock(newStock);
        }
    }

    public List<Product> recommendations() {
        Map<Product, Integer> productFrequency = new HashMap<>();

        // Count the frequency of each product
        for (Order order : orders.values()) {
            order.getOrderDetails().forEach((product, quantity) ->
                    productFrequency.merge(product, quantity, Integer::sum)
            );
        }

        List<Map.Entry<Product, Integer>> sortedProducts = new ArrayList<>(productFrequency.entrySet());
        sortedProducts.sort(Map.Entry.<Product, Integer>comparingByValue().reversed());

        return sortedProducts.stream()
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }
}