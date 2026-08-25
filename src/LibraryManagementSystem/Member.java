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

    @Override
    public String getRole() {
        return "MEMBER";
    }
}
