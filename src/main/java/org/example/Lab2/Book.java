package org.example.Lab2;

public class Book extends Item{

    private String author;

    public Book(String title, String uniqueID, String author) {
        super(title, uniqueID);
        this.author = author;
    }

    @Override
    public void borrowItem() {
        isBorrowed = true;
    }

    @Override
    public void returnItem() {
        isBorrowed = false;
    }

    public String getAuthor() {
        return author;
    }


}