package org.example.Lab7;

import java.util.*;

class ECommerceDemo {
    public static void main(String[] args) {
        ECommercePlatform platform = new ECommercePlatform();

        User user1 = new User(1, "user1", new HashMap<>());
        User user2 = new User(2, "user2", new HashMap<>());
        platform.addUser(user1);
        platform.addUser(user2);

        Product product1 = new Product(1, "Product1", 20.0, 10);
        Product product2 = new Product(2, "Product2", 30.0, 5);
        Product product3 = new Product(3, "Product3", 15.0, 8);

        platform.addProduct(product1);
        platform.addProduct(product2);
        platform.addProduct(product3);

        user1.addProduct(product1, 2);
        user1.addProduct(product2, 1);

        user2.addProduct(product2, 3);
        user2.addProduct(product3, 2);


        user1.removeProduct(product2);

        platform.createOrder(user1.getId(), user1.getCart());
        platform.createOrder(user2.getId(), user2.getCart());

        Output(platform);
    }

    private static List<Product> sortProductsByName(List<Product> products) {
        List<Product> sortedProducts = new ArrayList<>(products);
        sortedProducts.sort(Product.nameComparator());
        return sortedProducts;
    }

    private static List<Product> sortProductsByStock(List<Product> products) {
        List<Product> sortedProducts = new ArrayList<>(products);
        sortedProducts.sort(Product.stockComparator());
        return sortedProducts;
    }


    private static List<Product> sortProductsByPrice(List<Product> products) {
        List<Product> sortedProducts = new ArrayList<>(products);
        sortedProducts.sort(Comparator.comparing(Product::getPrice));
        return sortedProducts;
    }

    private static List<Product> filterProductsByStock(List<Product> products) {
        return products.stream()
                .filter(product -> product.getStock() > 0)
                .toList();
    }

    private static void Output(ECommercePlatform platform) {
        System.out.println("Customers:");
        platform.listUsers().forEach(user ->
                System.out.println(user.getId() + ". " + user.getUsername())
        );

        System.out.println("\nProducts:");
        sortProductsByName(platform.listAvailableProducts()).forEach(product ->
                System.out.println(product.getId() + ". " + product.getName())
        );

        System.out.println("\nProducts (Sorted by Price):");
        sortProductsByPrice(platform.listAvailableProducts()).forEach(product ->
                System.out.println(product.getId() + ". " + product.getName() + " - $" + product.getPrice())
        );

        System.out.println("\nProducts (Sorted by Stock):");
        sortProductsByStock(platform.listAvailableProducts()).forEach(product ->
                System.out.println(product.getId() + ". " + product.getName() + " - Stock: " + product.getStock())
        );

        System.out.println("\nProducts (Stock > 0):");
        filterProductsByStock(platform.listAvailableProducts()).forEach(product ->
                System.out.println(product.getId() + ". " + product.getName() + " - Stock: " + product.getStock())
        );

        System.out.println("\nOrders:");
        platform.listOrders().forEach(order -> {
            System.out.println(order.getId() + ". Customer " + order.getUserId() + " ordered:");
            order.getOrderDetails().forEach((product, quantity) ->
                    System.out.println("     " + product.getName() + " x " + quantity)
            );
            System.out.println("     Total price: " + order.getTotalPrice());
        });

        System.out.println("\nRecommendations (most popular products):");
        List<Product> popularProducts = platform.recommendations();
        popularProducts.forEach(product ->
                System.out.println(" - " + product.getName())
        );
    }


}
