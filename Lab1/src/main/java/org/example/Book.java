package org.example;
public class Book {

    public String name;
    public String author;
    public String isbn;
    public int year;

    public Book(String name, String author, String isbn, int year) {
        this.name = name;
        this.author = author;
        this.isbn = isbn;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public String toString(){
        return "\nName: " + name + "\nAuthor: " + author + "\nISBN: " + isbn + "\nyear: " + year;
    }
}
