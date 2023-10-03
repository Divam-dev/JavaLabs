package org.example.Lab2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library implements IManageable {
    List<Item> items = new ArrayList<>();
    List<Patron> patrons = new ArrayList<>();
    private Map<Item, List<Patron>> borrowedItemsMap = new HashMap<>();

    public void registerPatron(Patron patron) {
        patrons.add(patron);
    }

    public void lendItem(Patron patron, Item item) {
        if (patrons.contains(patron)) {
            patron.borrow(item);

            List<Patron> borrowers = borrowedItemsMap.getOrDefault(item, new ArrayList<>());
            borrowers.add(patron);
            borrowedItemsMap.put(item, borrowers);
        }
    }

    public void returnItem(Patron patron, Item item) {
        if (patrons.contains(patron)) {
            patron.returnItem(item);

            List<Patron> borrowers = borrowedItemsMap.get(item);
            if (borrowers != null) {
                borrowers.remove(patron);
            }
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
                System.out.println("- " + item.getTitle());
            }
        }
    }
    @Override
    public void listBorrowed() {
        System.out.println("Borrowed Items:");
        for (Item item : borrowedItemsMap.keySet()) {
            List<Patron> borrowers = borrowedItemsMap.get(item);
            System.out.print("- " + item.getTitle() + " (Borrowed by: ");
            for (int i = 0; i < borrowers.size(); i++) {
                System.out.print(borrowers.get(i).getName());
                if (i < borrowers.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println(")");
        }
    }

    public List<Item> getItems() {
        return items;
    }

    public List<Patron> getPatrons() {
        return patrons;
    }
}
