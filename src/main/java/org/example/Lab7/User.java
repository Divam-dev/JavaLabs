package org.example.Lab7;

import java.util.Map;

public class User {
    private final Integer id;
    private final String username;
    private final Map<Product, Integer> cart;

    public User(Integer id, String username, Map<Product, Integer> cart) {
        this.id = id;
        this.username = username;
        this.cart = cart;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public Map<Product, Integer> getCart() {
        return cart;
    }

    public void addProduct(Product product, int count) {
        cart.put(product, count);
    }

    public void removeProduct(Product product) {
        cart.remove(product);
    }

    public String toString() {
        return "User " +
                "id=" + id +
                ", username='" + username + '\'' +
                ", cart=" + cart;
    }
}
