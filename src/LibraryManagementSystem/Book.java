package LibraryManagementSystem;

public class Book {
    private static int lastAssignedId = 0;
    private final int bookId;
    private String name;
    private int yearPublished;
    private String genre;
    private String author;
    private int quantity;

    public Book(String name, int yearPublished, String genre, String author, int quantity) {
        lastAssignedId++;
        this.bookId = lastAssignedId;
        setYearPublished(yearPublished);
        setName(name);
        setGenre(genre);
        setAuthor(author);
        setQuantity(quantity);
    }

    public int getId() {
        return bookId;
    }

    public String getName() {
        return name;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public String getGenre() {
        return genre;
    }

    public String getAuthor() {
        return author;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void borrowBook() {
        quantity--;
    }

    public void returnBook() {
        quantity++;
    }

    @Override
    public String toString() {
        return " | " + bookId +
                " | " + name +
                " |    " + yearPublished +
                "    | " + genre +
                " | " + author +
                " | " + quantity +
                " | \n__________________________________________________________________________________________________________";
    }
}
