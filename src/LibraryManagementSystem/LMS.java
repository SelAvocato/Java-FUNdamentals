package LibraryManagementSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LMS {
    Scanner scan = new Scanner(System.in);

    enum Page {
        HOME, DISPLAY, BORROW_BOOK, RETURN_BOOK, NULL
    }

    final int RETURN_OPERATION = 0;
    final int DISPLAY_BOOKS_OPERATION = 1;
    final int BORROW_BOOK_OPERATION = 2;
    final int RETURN_BOOK_OPERATION = 3;

    Page currentPage = Page.HOME;
    int operation = 0;

    List<Book> books = getBooks();

    public void home() {
        while (currentPage == Page.HOME) {
            getOperations();
        }
    }

    public static List<Book> getBooks() {
        Book prideAndPrejudiceBook = new Book("Pride and Prejudice",    1813, "Romance", "Jane Austen", 15);
        Book mobyDickBook = new Book("Moby-Dick", 1851, "Adventure", "Herman Melville", 8);
        return new ArrayList<>(List.of(prideAndPrejudiceBook, mobyDickBook));
    }

    public void getOperations() {
        try {
            System.out.print("Operations: 1. Display books | 2. Borrow books | 3. Return books | 4. Exit\nEnter a number: ");
            operation = scan.nextInt();

            switch (operation) {
                case 1 -> displayBooks();
                case 2 -> borrowBook();
                case 3 -> returnBook();
                case 4 -> exit();
                default -> handleInvalidInput();
            }
        } catch (Exception e) {
            handleInvalidInput();
        }
    }

    public void displayBooks() {
        System.out.println("| Id |       Name       | Year Published | Genre |    Author    | Quantity | ");
        for (Book book : books) {
            System.out.println(book);
        }
        if (operation != DISPLAY_BOOKS_OPERATION) return;
        getOperations();
    }

    public void borrowBook() {
        displayBooks();
        currentPage = Page.BORROW_BOOK;
        while (currentPage == Page.BORROW_BOOK) {
            try {
                System.out.print("Enter 0 to return\nEnter the ID of the book you want to borrow: ");
                int bookId = scan.nextInt();
                if (bookId == RETURN_OPERATION) {
                    currentPage = Page.HOME;
                    home();
                    return;
                }
                boolean foundBook = false;
                for (Book book : books) {
                    if (book.getId() != bookId) continue;
                    book.borrowBook();
                    foundBook = true;
                    System.out.println("You borrowed " + book.name);
                }
                if (!foundBook) {
                    System.out.println("Book ID not found");
                } else {
                    currentPage = Page.HOME;
                }
            } catch (Exception e) {
                handleInvalidInput();
            }
        }
        getOperations();
    }

    public static void returnBook() {

    }

    public void exit() {
        System.out.println("Goodbye");
        currentPage = Page.NULL;
        scan.close();
    }

    public void handleInvalidInput() {
        System.out.println("Invalid input");
        scan.nextLine();
    }
}
