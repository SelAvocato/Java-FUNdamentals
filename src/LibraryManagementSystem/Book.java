package LibraryManagementSystem;

public class Book {
    private static int lastAssignedId = 0;
    private final int bookId;
    String name;
    int yearPublished;
    String genre;
    String author;
    private int quantity;

    public Book(String name, int yearPublished, String genre, String author, int quantity) {
        lastAssignedId++;
        this.bookId = lastAssignedId;
        this.name = name;
        this.yearPublished = yearPublished;
        this.genre = genre;
        this.author = author;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    void borrowBook() {
        quantity--;
    }

    void returnBook() {
        quantity++;
    }

    @Override
    public String toString() {
        return  " | " + bookId +
                " | " + name +
                " |    " + yearPublished +
                "    | " + genre +
                " | " + author +
                " | " + quantity +
                " | \n__________________________________________________________________________________________________________";
    }
}
