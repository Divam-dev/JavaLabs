package org.example.Lab6;

public class Seat {
    private final int hallNumber;
    private final int rowNumber;
    private final int seatNumber;

    public Seat(int hallNumber, int rowNumber, int seatNumber){
        this.hallNumber = hallNumber;
        this.rowNumber = rowNumber;
        this.seatNumber = seatNumber;
    }

    public int getHallNumber() {
        return hallNumber;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public int getSeatNumber() {
        return seatNumber;
    }
}
