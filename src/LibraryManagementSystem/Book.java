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

    public void setYearPublished(int newYearPublished) {
        yearPublished = newYearPublished;
    }

    public void setGenre(String newGenre) {
        genre = newGenre;
    }

    public void setAuthor(String newAuthor) {
        author = newAuthor;
    }

    public void setQuantity(int newQuantity) {
        quantity = newQuantity;
    }

    public void setName(String newName) {
        name = newName;
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
