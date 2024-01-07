package org.example.Lab9;

import java.util.List;
import java.io.File;

public class Main {

    public static void main(String[] args) {

        FakeStoreAPI fakeStoreAPI = new FakeStoreAPI();

        List<Category> categories = fakeStoreAPI.getCategories();

        List<User> users = fakeStoreAPI.getUsers();

        List<Product> products = fakeStoreAPI.getProducts();

        // Create Tables folder
        String tablesFolderPath = "src/main/java/org/example/Lab9/Tables";
        File tablesFolder = new File(tablesFolderPath);
        if (!tablesFolder.exists()) {
            boolean created = tablesFolder.mkdirs();
            if (!created) {
                System.err.println("Failed to create Tables folder.");
                return;
            }
        }

        // Export Categories to Excel
        String categoriesFilePath = tablesFolderPath + "/Categories.xlsx";
        ExcelExporter.exportCategories(categories, categoriesFilePath);
        System.out.println("Categories exported to: " + categoriesFilePath);

        // Export Users to Excel
        String usersFilePath = tablesFolderPath + "/Users.xlsx";
        ExcelExporter.exportUsers(users, usersFilePath);
        System.out.println("Users exported to: " + usersFilePath);

        // Export Products to Excel
        String productsFilePath = tablesFolderPath + "/Products.xlsx";
        ExcelExporter.exportProducts(products, productsFilePath);
        System.out.println("Products exported to: " + productsFilePath);
    }
}

