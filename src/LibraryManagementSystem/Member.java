package LibraryManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Member extends User {
    private final List<Integer> borrowedBooksId;

    public Member(String username, String firstName, String lastName, String password) throws Exception {
        super(username, firstName, lastName, password);
        this.borrowedBooksId = new ArrayList<>();
    }

    public void addBorrowedBookId(int borrowedBookId) {
        this.borrowedBooksId.add(borrowedBookId);
    }

    public List<Integer> getBorrowedBooksId() {
        return borrowedBooksId;
    }

    public void borrowBook(int bookId) throws Exception {
        if (borrowedBooksId.contains(bookId)) {
            throw new Exception("Book is already borrowed by this member");
        }
        borrowedBooksId.add(bookId);
    }

    public void returnBook(int bookId) throws Exception {
        if (!borrowedBooksId.contains(bookId)) {
            throw new Exception("This book was not borrowed by this member");
        }
        borrowedBooksId.remove(Integer.valueOf(bookId));
    }

    @Override
    public String getRole() {
        return "MEMBER";
    }
}
