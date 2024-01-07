package org.example.Lab9;

import java.util.List;

public class Product {
    private final int id;
    private final String title;
    private final int price;
    private final String description;
    private final List<String> images;
    private final String updatedAt;
    private final Category category;

    public Product(int id, String title, int price, String description, List<String> images, String updatedAt, Category category) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.description = description;
        this.images = images;
        this.updatedAt = updatedAt;
        this.category = category;
    }

    public Product() {
        this.id = 0;
        this.title = "";
        this.price = 0;
        this.description = "";
        this.images = null;
        this.updatedAt = "";
        this.category = null;
    }

    public int getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public int getPrice() {
        return this.price;
    }

    public String getDescription() {
        return this.description;
    }

    public List<String> getImages() {
        return this.images;
    }

    public String getUpdatedAt() {
        return this.updatedAt;
    }

    public Category getCategory() {
        return this.category;
    }
}

