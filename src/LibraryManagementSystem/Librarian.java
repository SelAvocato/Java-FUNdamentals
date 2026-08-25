package LibraryManagementSystem;

public class Librarian extends User {
    private String employeeId;

    public Librarian(String username, String firstName, String lastName, String password, String employeeId) throws Exception {
        super(username, firstName, lastName, password);
        this.employeeId = employeeId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String getRole() {
        return "LIBRARIAN";
    }
}
