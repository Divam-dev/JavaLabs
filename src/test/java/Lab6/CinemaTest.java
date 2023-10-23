package Lab6;

import org.example.Lab6.Cinema;
import org.example.Lab6.Seat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CinemaTest {
    Cinema cinema;

    @BeforeEach
    public void setup() {
        cinema = new Cinema(5, 3, 10);
    }

    @Test
    public void testBookSeats() {
        int hallNumber = 0;
        int rowNumber = 1;
        int[] seatNumbers = {1, 2, 3, 5, 7};

        cinema.bookSeats(hallNumber, rowNumber, seatNumbers);

        assertTrue(cinema.isSeatBooked(hallNumber, rowNumber, 1));
        assertTrue(cinema.isSeatBooked(hallNumber, rowNumber, 2));
        assertTrue(cinema.isSeatBooked(hallNumber, rowNumber, 3));
        assertTrue(cinema.isSeatBooked(hallNumber, rowNumber, 5));
        assertTrue(cinema.isSeatBooked(hallNumber, rowNumber, 7));
    }

    @Test
    public void testInvalidHallNumber() {
        int hallNumber = -1;
        int rowNumber = 1;
        int[] seatNumbers = {1, 2, 3, 5, 7};

        assertFalse(cinema.bookSeats(hallNumber, rowNumber, seatNumbers));
    }

    @Test
    public void testCancelBooking() {
        int hallNumber = 0;
        int rowNumber = 1;
        int[] seatNumbers = {1, 2, 3, 5, 7};
        int[] seatsToCancel = {3, 5, 7};
        cinema.bookSeats(hallNumber, rowNumber, seatNumbers);

        cinema.cancelBooking(hallNumber, rowNumber, seatsToCancel);

        assertFalse(cinema.isSeatBooked(hallNumber, rowNumber, 3));
        assertFalse(cinema.isSeatBooked(hallNumber, rowNumber, 5));
        assertFalse(cinema.isSeatBooked(hallNumber, rowNumber, 7));
    }

    @Test
    void testCheckAvailability() {
        int hallNumber = 0;
        int row = 1;

        int numSeatsToCheck = 10;
        int numSeats = 99;
        assertTrue(cinema.checkAvailability(hallNumber, row, numSeatsToCheck));
        assertFalse(cinema.checkAvailability(hallNumber, row, numSeats));
    }

    @Test
    void testPrintSeatingArrangement() {
        int hallNumber = 0;
        int row = 1;

        int[] seats = {2, 3, 4, 5};
        cinema.bookSeats(hallNumber, row, seats);

        assertDoesNotThrow(() -> cinema.printSeatingArrangement(0));
    }

    @Test
    public void testFindBestAvailable() {
        List<Seat[]> bestAvailableSeats = cinema.findBestAvailable(0, 4);
        assertNotNull(bestAvailableSeats);
        assertEquals(6, bestAvailableSeats.size());

        Seat[] seats = bestAvailableSeats.get(0);
        for (int i = 1; i < seats.length; i++) {
            assertEquals(seats[i - 1].getSeatNumber() + 1, seats[i].getSeatNumber());
        }
    }

    @Test
    public void testAutoBook() {
        cinema.bookSeats(1, 2, new int[]{2, 3, 4, 5, 6, 7, 8, 9});

        boolean booked = cinema.autoBook(1, 4);

        assertTrue(booked);

        assertTrue(cinema.isSeatBooked(1, 2, 5));
        assertTrue(cinema.isSeatBooked(1, 2, 6));
        assertTrue(cinema.isSeatBooked(1, 2, 7));
        assertTrue(cinema.isSeatBooked(1, 2, 8));
    }

    @Test
    void testAutoBookAndPrintResult() {
        int hallNumber = 0;
        int numSeats = 5;

        assertTrue(cinema.autoBook(hallNumber, numSeats));
        cinema.printSeatingArrangement(hallNumber);
    }
}
