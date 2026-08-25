package LibraryManagementSystem;

public class Admin extends User {

    public Admin(String username, String firstName, String lastName, String password) throws Exception {
        super(username, firstName, lastName, password);
    }

    @Override
    public String getRole() {
        return "ADMIN";
    }
}
