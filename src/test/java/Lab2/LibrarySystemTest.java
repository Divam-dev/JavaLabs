package Lab2;

import org.example.Lab2.Book;
import org.example.Lab2.DVD;
import org.example.Lab2.Library;
import org.example.Lab2.Patron;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LibrarySystemTest {

    private Library library;

    @BeforeEach
    public void setUp() {
        library = new Library();
        Book book = new Book("The Hobbit", "5432", "J.R.R. Tolkien");
        DVD dvd = new DVD("Forrest Gump", "234567", 142);
        Patron patron = new Patron("Test Patron", "23456");

        library.add(book);
        library.add(dvd);
        library.registerPatron(patron);
    }

    @Test
    public void testAddItem() {
        Book book1 = new Book("Harry Potter and the Sorcerer's Stone", "2468", "J.K. Rowling");
        DVD dvd1 = new DVD("The Matrix", "567890", 136);
        library.add(book1);
        library.add(dvd1);
        assertTrue(library.getItems().contains(book1));
        assertTrue(library.getItems().contains(dvd1));
    }

    @Test
    public void testRemoveItem() {
        Book book1 = new Book("Harry Potter and the Sorcerer's Stone", "2468", "J.K. Rowling");
        DVD dvd1 = new DVD("The Matrix", "567890", 136);
        DVD dvd2 = new DVD("Gladiator", "123123", 155);
        library.add(book1);
        library.add(dvd1);
        library.add(dvd2);
        library.remove(dvd1);
        assertTrue(library.getItems().contains(book1));
        assertFalse(library.getItems().contains(dvd1));
        assertTrue(library.getItems().contains(dvd2));

    }

    @Test
    public void testListAvailable() {
        Book book1 = new Book("Harry Potter and the Sorcerer's Stone", "2468", "J.K. Rowling");
        DVD dvd1 = new DVD("The Matrix", "567890", 136);
        DVD dvd2 = new DVD("Gladiator", "123123", 155);
        library.add(book1);
        library.add(dvd1);
        library.add(dvd2);
        library.listAvailable();
    }

    @Test
    void testRegisterPatron() {
        Patron patron = new Patron("Oleksandr", "78901");
        library.registerPatron(patron);
        assertTrue(library.getPatrons().contains(patron));
    }

    @Test
    void testLendItem() {
        var patron = new Patron("Oleksandr", "78901");
        var book = new Book("Harry Potter and the Sorcerer's Stone", "2468", "J.K. Rowling");
        library.registerPatron(patron);
        library.add(book);
        library.lendItem(patron, book);
        assertTrue(patron.getBorrowedItems().contains(book));
    }

    @Test
    void testReturnItem() {
        var patron = new Patron("Oleksandr", "78901");
        var book = new Book("Harry Potter and the Sorcerer's Stone", "2468", "J.K. Rowling");
        library.registerPatron(patron);
        library.add(book);
        library.lendItem(patron, book);
        library.returnItem(patron, book);
        assertFalse(patron.getBorrowedItems().contains(book));
    }

    @Test
    void testListBorrowed() {
        var patron1 = new Patron("Oleksandr", "78901");
        var patron2 = new Patron("Ivan", "78901");
        var book = new Book("Harry Potter and the Sorcerer's Stone", "2468", "J.K. Rowling");
        var dvd = new DVD("The Matrix", "567890", 136);
        library.registerPatron(patron1);
        library.registerPatron(patron2);
        library.add(book);
        library.add(dvd);
        library.lendItem(patron1, book);
        library.lendItem(patron1, dvd);
        library.lendItem(patron2, dvd);
        library.listBorrowed();
    }

}
