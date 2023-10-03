package org.example.Lab2;

public interface IManageable {
    void add(Item item);
    boolean remove(Item item);
    void listAvailable();
    void listBorrowed();

}