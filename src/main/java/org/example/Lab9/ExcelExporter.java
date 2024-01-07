package org.example.Lab9;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelExporter {

    public static void exportCategories(List<Category> categories, String filePath) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Categories");

            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("ID");
            headerRow.createCell(1).setCellValue("Name");
            headerRow.createCell(2).setCellValue("Image");
            headerRow.createCell(3).setCellValue("UpdatedAt");

            int rowNum = 1;
            for (Category category : categories) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(category.id());
                row.createCell(1).setCellValue(category.name());
                row.createCell(2).setCellValue(category.image());
                row.createCell(3).setCellValue(category.updatedAt());
            }

            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                workbook.write(fileOut);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void exportUsers(List<User> users, String filePath) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Users");

            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("ID");
            headerRow.createCell(1).setCellValue("Email");
            headerRow.createCell(2).setCellValue("Password");
            headerRow.createCell(3).setCellValue("Name");
            headerRow.createCell(4).setCellValue("Role");
            headerRow.createCell(5).setCellValue("Avatar");
            headerRow.createCell(6).setCellValue("UpdatedAt");
            int rowNum = 1;
            for (User user : users) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(user.getId());
                row.createCell(1).setCellValue(user.getEmail());
                row.createCell(2).setCellValue(user.getPassword());
                row.createCell(3).setCellValue(user.getName());
                row.createCell(4).setCellValue(user.getRole());
                row.createCell(5).setCellValue(user.getAvatar());
                row.createCell(6).setCellValue(user.getUpdatedAt());
            }

            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                workbook.write(fileOut);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void exportProducts(List<Product> products, String filePath) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Products");

            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("ID");
            headerRow.createCell(1).setCellValue("Title");
            headerRow.createCell(2).setCellValue("Price");
            headerRow.createCell(3).setCellValue("Description");
            headerRow.createCell(4).setCellValue("Images");
            headerRow.createCell(5).setCellValue("UpdatedAt");
            headerRow.createCell(7).setCellValue("Category ID");
            headerRow.createCell(8).setCellValue("Category Name");
            headerRow.createCell(9).setCellValue("Category Image");
            headerRow.createCell(10).setCellValue("Category UpdatedAt");

            int rowNum = 1;
            for (Product product : products) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(product.getId());
                row.createCell(1).setCellValue(product.getTitle());
                row.createCell(2).setCellValue(product.getPrice());
                row.createCell(3).setCellValue(product.getDescription());
                row.createCell(4).setCellValue(String.join(", ", product.getImages()));
                row.createCell(5).setCellValue(product.getUpdatedAt());

                Category category = product.getCategory();
                row.createCell(7).setCellValue(category.id());
                row.createCell(8).setCellValue(category.name());
                row.createCell(9).setCellValue(category.image());
                row.createCell(10).setCellValue(category.updatedAt());
            }

            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                workbook.write(fileOut);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
