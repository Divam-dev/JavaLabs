package org.example.Lab2;

import java.util.ArrayList;
import java.util.List;
public class Library implements IManageable {
    List<Item> items = new ArrayList<>();
    List<Patron> patrons = new ArrayList<>();

    public void registerPatron(Patron patron) {
        patrons.add(patron);
    }

    public void lendItem(Patron patron, Item item) {
        if (patrons.contains(patron)) {
            patron.borrow(item);
        }
    }

    public void returnItem(Patron patron, Item item) {
        if (patrons.contains(patron)) {
            patron.returnItem(item);
        }
    }

    @Override
    public void add(Item item) {
        items.add(item);
    }

    @Override
    public boolean remove(Item item) {
       return items.remove(item);
    }
    @Override
    public void listAvailable() {
        System.out.println("Available Items:");
        for (Item item : items) {
            if (!item.isBorrowed) {
                System.out.println("- " + item.title);
            }
        }
    }

    @Override
    public void listBorrowed() {
        System.out.println("Borrowed Items:");
        for (Item item : items) {
            if (item.isBorrowed) {
                System.out.println("- " + item.title);
            }
        }
    }

    public List<Item> getItems() {
        return items;
    }

    public List<Patron> getPatrons() {
        return patrons;
    }
}
