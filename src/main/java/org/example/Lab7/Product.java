package org.example.Lab7;

import java.util.Comparator;

public class Product implements Comparable<Product> {
    private int id;
    private final String name;
    private double price;
    private int stock;

    public Product(String name) {
        this.name = name;
    }

    public Product(Integer id, String name, double price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public static Comparator<Product> nameComparator() {
        return (product1, product2) -> product1.name.compareTo(product2.name);
    }

    public static Comparator<Product> stockComparator() {
        return (product1, product2) -> product1.stock - product2.stock;
    }

    @Override
    public int compareTo(Product o) {
        return Double.compare(this.price, o.price);
    }

    public String toString() {
        return "Product " +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock;
    }
}
