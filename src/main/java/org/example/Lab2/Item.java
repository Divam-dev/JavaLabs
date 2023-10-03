package org.example.Lab2;

public abstract class Item {
    protected String title;
    private final String uniqueID;
    protected boolean isBorrowed;

    public Item(String title, String uniqueID) {
        this.title = title;
        this.uniqueID = uniqueID;
        this.isBorrowed = false;
    }

    public abstract void borrowItem();

    public abstract void returnItem();

    public String getUniqueID() {
        return uniqueID;
    }

    public String getTitle() {
        return title;
    }
}