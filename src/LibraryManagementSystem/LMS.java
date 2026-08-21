package LibraryManagementSystem;

import java.util.Scanner;

public class LMS {
    Scanner scan = new Scanner(System.in);
    Book prideAndPrejudiceBook = new Book("Pride and Prejudice", 1813, "Romance", "Jane Austen", 15);
    Book mobyDickBook = new Book("Mobe-Dick", 1851, "Adventure", "Herman Melville", 8);
    Object[] books = {prideAndPrejudiceBook, mobyDickBook};
    int page = 1;

    enum Page {
        HOME, DISPLAY, BORROW_BOOK, RETURN_BOOK, NULL
    }

    final int DISPLAY_BOOKS_OPERATION = 1;
    final int BORROW_BOOK_OPERATION = 2;
    final int RETURN_BOOK_OPERATION = 3;

    Page currentPage = Page.HOME;
    int operation = 0;


    public void home() {
        while (currentPage == Page.HOME) {
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
    }

    public void displayBooks(Object[] books) {
        page = 2;
    public void displayBooks() {
        System.out.println("| Id |       Name       | Year Published | Genre |    Author    | Quantity | ");
        for (Object book : books) {
            System.out.println(book);
        }
        if (operation != DISPLAY_BOOKS_OPERATION) return;
        currentPage = Page.DISPLAY;
        while (currentPage == Page.DISPLAY) {
            try {
                System.out.print("Operations: 1. Return | 2. Exit\nEnter a number: ");
                operation = scan.nextInt();
                switch (operation) {
                    case 1 -> currentPage = Page.HOME;
                    case 2 -> exit();
                    default -> handleInvalidInput();
                }
            } catch (Exception e) {
                handleInvalidInput();
            }
        }
    }

    public void borrowBook() {
        displayBooks(books);
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
