package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Cart cart = new Cart();
        int orderId = 1;

        List<Order> orders = new ArrayList<>();

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add Product to Cart");
            System.out.println("2. Remove Product from Cart");
            System.out.println("3. Place Order");
            System.out.println("4. Check Order status");
            System.out.println("0. Exit\n");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID: ");
                    int productId;
                    while (true) {
                        if (scanner.hasNextInt()) {
                            productId = scanner.nextInt();
                            break;
                        } else {
                            System.out.println("Invalid product ID. Please enter a number.");
                            scanner.next();
                        }
                    }

                    System.out.print("Enter Product Name: ");
                    String productName = scanner.next();
                    while (productName.isEmpty()) {
                        System.out.println("Product name cannot be empty. Please enter a valid name.");
                        productName = scanner.next();
                    }

                    double productPrice;
                    while (true) {
                        System.out.print("Enter Product Price: ");
                        if (scanner.hasNextDouble()) {
                            productPrice = scanner.nextDouble();
                            break;
                        } else {
                            System.out.println("Invalid product price. Please enter a valid number.");
                            scanner.next();
                        }
                    }

                    Product product = new Product(productId, productName, productPrice);
                    cart.addProduct(product);
                    System.out.println(productName + " added to cart.");
                    break;
                case 2:
                    System.out.print("Enter Product ID to remove: ");
                    int productIdToRemove;
                    while (true) {
                        if (scanner.hasNextInt()) {
                            productIdToRemove = scanner.nextInt();
                            break;
                        } else {
                            System.out.println("Invalid product ID. Please enter a number.");
                            scanner.next();
                        }
                    }

                    List<Product> productsInCart = cart.getProducts();
                    Product productToRemove = null;
                    for (Product p : productsInCart) {
                        if (p.getId() == productIdToRemove) {
                            productToRemove = p;
                            break;
                        }
                    }

                    if (productToRemove != null) {
                        cart.removeProduct(productToRemove);
                        System.out.println("Product removed from cart.");
                    } else {
                        System.out.println("Product not found in cart.");
                    }
                    break;
                case 3:
                    List<Product> productsInOrder = cart.getProducts();
                    if (productsInOrder.isEmpty()) {
                        System.out.println("Cart is empty. Cannot place an empty order.");
                    } else {
                        Order order = new Order(orderId++, productsInOrder);
                        orders.add(order);
                        System.out.println("Order placed successfully.");
                        System.out.println("Order ID: " + order.getOrderId());
                        System.out.println("Order Status: " + order.getStatus());

                        System.out.println("Products in Order:");
                        for (Product orderedProduct : productsInOrder) {
                            System.out.println(orderedProduct);
                        }

                        cart.clearCart();
                    }
                    break;
                case 4:
                    System.out.print("Enter Order ID to check: ");
                    int searchOrderId;
                    while (true) {
                        if (scanner.hasNextInt()) {
                            searchOrderId = scanner.nextInt();
                            break;
                        } else {
                            System.out.println("Invalid Order ID. Please enter a number.");
                            scanner.next();
                        }
                    }

                    boolean found = false;
                    for (Order order : orders) {
                        if (order.getOrderId() == searchOrderId) {
                            System.out.println("Order ID " + searchOrderId + ": " + order.getStatus());
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Order with ID " + searchOrderId + " not found.");
                    }
                    break;
                case 0:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}