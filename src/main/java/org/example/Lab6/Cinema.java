package org.example.Lab6;

import java.util.ArrayList;
import java.util.List;

public class Cinema {
    private final int hallNumber;
    private final int rowNumber;
    private final int seatNumber;
    private final int[][][] seats;

    public Cinema(int hallNumber, int rowNumber, int seatNumber) {
        this.hallNumber = hallNumber;
        this.rowNumber = rowNumber;
        this.seatNumber = seatNumber;
        seats = new int[hallNumber][rowNumber][seatNumber];
    }

    public boolean bookSeats(int hallNumber, int row, int[] seatsToBook) {
        if (hallNumber < 0 || hallNumber >= this.hallNumber || row < 0 || row >= rowNumber) {
            return false;
        }

        for (int seat : seatsToBook) {
            if (seat < 0 || seat >= seatNumber) {
                return false;
            }
            if (seats[hallNumber][row][seat] == 1) {
                return false;
            }
        }


        for (int seat : seatsToBook) {
            seats[hallNumber][row][seat] = 1;
        }

        return true;
    }


    public boolean isSeatBooked(int hallNumber, int row, int seat) {
        return seats[hallNumber][row][seat] == 1;
    }

    public boolean cancelBooking(int hallNumber, int row, int[] seatsToCancel) {
        if (hallNumber < 0 || hallNumber >= this.hallNumber || row < 0 || row >= rowNumber) {
            return false;
        }

        for (int seat : seatsToCancel) {
            if (seat < 0 || seat >= seatNumber) {
                return false;
            }
            if (seats[hallNumber][row][seat] == 0) {
                return false;
            }
        }


        for (int seat : seatsToCancel) {
            seats[hallNumber][row][seat] = 0;
        }

        return true;
    }

    public boolean checkAvailability(int hallNumber, int row, int numSeats) {
        if (hallNumber < 0 || hallNumber >= this.hallNumber || row < 0 || row >= rowNumber || numSeats <= 0) {
            return false;
        }

        int consecutiveSeats = 0;

        for (int seat = 0; seat < seatNumber; seat++) {
            if (seats[hallNumber][row][seat] == 0) {
                consecutiveSeats++;

                if (consecutiveSeats == numSeats) {
                    return true;
                }
            } else {
                consecutiveSeats = 0;
            }
        }

        return false;
    }


    public List<Seat[]> findBestAvailable(int hallNumber, int numSeats) {
        if (hallNumber < 0 || hallNumber >= this.hallNumber || numSeats <= 0) {
            return new ArrayList<>();
        }

        List<Seat[]> bestAvailableSeats = new ArrayList<>();
        List<Seat> currentSeats = new ArrayList<>();

        for (int row = 0; row < rowNumber; row++) {
            int consecutiveSeats = 0;

            for (int seat = 0; seat < seatNumber; seat++) {
                if (seats[hallNumber][row][seat] == 0) {
                    consecutiveSeats++;
                    currentSeats.add(new Seat(hallNumber, row, seat));

                    if (consecutiveSeats == numSeats) {
                        bestAvailableSeats.add(currentSeats.toArray(new Seat[0]));
                        currentSeats.clear();
                        consecutiveSeats = 0;
                    }
                } else {
                    currentSeats.clear();
                    consecutiveSeats = 0;
                }
            }
        }

        return bestAvailableSeats;
    }

    public boolean autoBook(int hallNumber, int numSeats) {
        List<Seat[]> bestAvailableSeats = findBestAvailable(hallNumber, numSeats);

        if (bestAvailableSeats.isEmpty()) {
            return false;
        }

        Seat[] seatsToBook = bestAvailableSeats.get(0);

        int[] seatNumbers = new int[seatsToBook.length];
        for (int i = 0; i < seatsToBook.length; i++) {
            seatNumbers[i] = seatsToBook[i].getSeatNumber();
        }

        return bookSeats(hallNumber, seatsToBook[0].getRowNumber(), seatNumbers);
    }
    public void printSeatingArrangement(int hallNumber) {
        if (hallNumber < 0 || hallNumber >= this.hallNumber) {
        System.out.println("Invalid hall number.");
        return;
    }

    System.out.println("  " + createSeatNumbers());

     for (int row = 0; row < rowNumber; row++) {
        System.out.print(row + " | ");
        for (int seat = 0; seat < seatNumber; seat++) {
            char status = (seats[hallNumber][row][seat] == 0) ? '0' : '1';
            String colorCode = (status == '0') ? "\u001B[32m" : "\u001B[31m";
            String bgColor = (status == '0') ? "\u001B[40m" : "\u001B[43m";
            String reset = "\u001B[0m";
            System.out.print(bgColor + colorCode + status + "  " + reset);
        }
        System.out.println("|" + row);
    }

    System.out.println("  " + createSeatNumbers());
}
    private String createSeatNumbers() {
        StringBuilder numbers = new StringBuilder();
        for (int seat = 0; seat < seatNumber; seat++) {
            numbers.append(String.format("%3d", seat));
        }
        return numbers.toString();
    }

}