package LibraryManagementSystem;

public abstract class User {
    private static int lastAssignedId = 0;
    private final int userId;
    private String username;
    private String firstName;
    private String lastName;
    private String password;

    static final int NAME_FIELD = 1;
    static final int CREDENTIALS_FIELD = 2;

    User(String username, String firstName, String lastName, String password) throws Exception {
        lastAssignedId++;
        this.userId = lastAssignedId;
        setUsername(username);
        setFirstName(firstName);
        setLastName(lastName);
        setPassword(password);
    }

    public abstract String getRole();

    public void setUsername(String username) throws Exception {
        if (isInvalidString(username, NAME_FIELD)) throw new Exception("Invalid username");
        this.username = username.trim();
    }

    public void setFirstName(String firstName) throws Exception {
        if (isInvalidString(firstName, NAME_FIELD)) throw new Exception("Invalid first name");
        this.firstName = firstName.trim();
    }

    public void setLastName(String lastName) throws Exception {
        if (isInvalidString(lastName, NAME_FIELD)) throw new Exception("Invalid last name");
        this.lastName = lastName.trim();
    }

    public void setPassword(String password) throws Exception {
        if (isInvalidString(password, CREDENTIALS_FIELD)) throw new Exception("Invalid password");
        this.password = password.trim();
    }

    public int getUserId() { return userId; }
    public String getUsername() { return username; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getFullName() { return firstName + " " + lastName; }
    public String getPassword() { return password; }

    boolean isInvalidString(String str, int field) {
        if (str == null) return true;
        String trimmedStr = str.trim();
        if (trimmedStr.isEmpty() || trimmedStr.length() > 255) return true;

        if (field == NAME_FIELD) {
            for (char c : trimmedStr.toCharArray()) {
                if (Character.isDigit(c)) return true;
            }
            return false;
        } else if (field == CREDENTIALS_FIELD) {
            if (trimmedStr.length() < 9) return true;
            for (char c : trimmedStr.toCharArray()) {
                if (Character.isWhitespace(c)) return true;
            }
            return false;
        }
        return false;
    }
}
