package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Library library = new Library();

        library.addBook(new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", "978-0-7475-3269-9", 1997));
        library.addBook(new Book("1984", "George Orwell", "978-0-452-28423-4", 1949));
        library.addBook(new Book("Pride and Prejudice", "Jane Austen", "978-0-14-143951-8", 1813));
        library.addBook(new Book("The Catcher in the Rye", "J.D. Salinger", "978-0-316-76948-4", 1951));
        library.addBook(new Book("The Lord of the Rings", "J.R.R. Tolkien", "978-0-345-33968-3", 1954));
        library.addBook(new Book("The Hobbit", "J.R.R. Tolkien", "978-0-261-10210-3", 1937));

        boolean running = true;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("\nEnter 1 to Add a book" + "\nEnter 2 to Find a book by name" + "\nEnter 3 to Remove a book by ISBN" + "\nEnter 4 to see all books" + "\nEnter 0 to Exit");

            System.out.println();
            String choice = scanner.next();

            switch (choice) {
                case "0":
                    running = false;
                    break;
                case "1":
                {
                    scanner.nextLine();
                    System.out.print("Enter the name of the book: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter the author of the book: ");
                    String author = scanner.nextLine();

                    System.out.print("Enter the ISBN of the book: ");
                    String isbn = scanner.nextLine();

                    System.out.print("Enter the year of the book: ");
                    int year = 0;
                    year = scanner.nextInt();

                    if (name.isEmpty() || author.isEmpty() || isbn.isEmpty() || year <= 0) {
                        System.out.println("Error: All fields must be filled out.");
                    } else {
                        library.addBook(new Book(name, author, isbn, year));
                        System.out.println("Book added.");
                    }
                    System.out.println();
                }
                break;
                case "2":
                {
                    scanner.nextLine();
                    System.out.print("Enter the name of the book: ");
                    String name = scanner.nextLine();

                    Book book = library.findBookByName(name);

                    if (book == null) {
                        System.out.println("Book not found.");
                    } else {
                        System.out.println(book);
                    }

                    System.out.println();
                }
                break;
                case "3":
                {
                    scanner.nextLine();
                    System.out.print("Enter the ISBN of the book: ");
                    String isbn = scanner.nextLine();

                    if (library.removeBookByISBN(isbn)) {
                        System.out.println("Book removed.");
                    } else {
                        System.out.println("Book not found.");
                    }

                    System.out.println();
                }
                break;
                case "4":
                {
                    System.out.println("Books in the library:");
                    for (Book book : library.getBooks()) {
                        System.out.println(book);
                    }

                    System.out.println();
                }
                break;
                default:
                    System.out.println("Invalid choice.");
                    System.out.println();
                    break;
            }
        } while (running);
    }
}
