package org.example.Lab2;

public class DVD extends Item {

    private int duration;

    public DVD(String title, String uniqueID, int duration) {
        super(title, uniqueID);
        this.duration = duration;
    }

    @Override
    public void borrowItem() {
        isBorrowed = true;
    }

    @Override
    public void returnItem() {
        isBorrowed = false;
    }

    public int getDuration() {
        return duration;
    }

}