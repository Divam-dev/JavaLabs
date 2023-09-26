package Lab1;

import org.example.Lab1.Book;
import org.example.Lab1.Library;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {

    private Library library;

    @BeforeEach
    void setUp() {
        library = new Library();
    }

    @Test
    public void testAddBook() {
        Book book1 = new Book("Book1", "Author1", "123-4-567-890", 2023);
        library.addBook(book1);

        assertTrue(library.getBooks().contains(book1));
    }

    @Test
    public void testFindBookByName() {
        Book book1 = new Book("Book1", "Author1", "1234567890", 2023);

        library.addBook(book1);

        Book foundBook = library.findBookByName("Book1");
        assertNotNull(foundBook);
        assertEquals(book1, foundBook);

    }

    @Test
    public void testRemoveBookByISBN() {
        Book book1 = new Book("Book1", "Author1", "1234567890", 2023);
        Book book2 = new Book("Book2", "Author2", "123456789", 2022);

        library.addBook(book1);
        library.addBook(book2);

        assertTrue(library.removeBookByISBN("1234567890"));
        assertNull(library.findBookByName("Book1"));
        assertEquals(1, library.getBooks().size());
    }
}