package org.example.Lab2;

import java.util.ArrayList;
import java.util.List;

public class Patron {
    protected String name;
    protected String ID;
    List<Item> borrowedItems = new ArrayList<>();

    public Patron(String name, String ID) {
        this.name = name;
        this.ID = ID;
    }

    public void borrow(Item item) {
        if (!item.isBorrowed) {
            borrowedItems.add(item);
            item.borrowItem();
        }
    }

    public void returnItem(Item item) {
        if (borrowedItems.contains(item)) {
            borrowedItems.remove(item);
            item.returnItem();
        }
    }
    public List<Item> getBorrowedItems() {
        return borrowedItems;
    }

    public String getName() {
        return name;
    }

    public String getID() {
        return ID;
    }

}