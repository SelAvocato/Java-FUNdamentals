package LibraryManagementSystem;

import java.util.Scanner;

public class LMS {
    Scanner scan = new Scanner(System.in);
    Book prideAndPrejudiceBook = new Book("Pride and Prejudice", 1813, "Romance", "Jane Austen", 15);
    Book mobyDickBook = new Book("Mobe-Dick", 1851, "Adventure", "Herman Melville", 8);
    Object[] books = {prideAndPrejudiceBook, mobyDickBook};
    int page = 1;

    public void home() {
        while (page == 1) {
            try {
                System.out.print("Operations: 1. Display books | 2. Borrow books | 3. Return books | 4. Exit\nEnter a number: ");
                int operation = scan.nextInt();

                switch (operation) {
                    case 1 -> displayBooks(books);
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
        System.out.println("| Id |       Name       | Year Published | Genre |    Author    | Quantity | ");
        for (Object book : books) {
            System.out.println(book);
        }
        while (page == 2) {
            try {
                System.out.print("Operations: 1. Return | 2. Exit\nEnter a number: ");
                int operation = scan.nextInt();
                switch (operation) {
                    case 1 -> page = 1;
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
        page = 0;
        scan.close();
    }

    public void handleInvalidInput() {
        System.out.println("Invalid input");
        scan.nextLine();
    }
}
