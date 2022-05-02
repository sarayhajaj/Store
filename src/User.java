import java.util.LinkedList;
import java.util.Scanner;

public class User {
    private String firstName;
    private String lastName;
    private String users;
    private String password;

    public User(String firstName , String lastName , String users ,String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.users = users ;
        this.password = password;
    }

    public User() {

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsers() {
        return users;
    }

    public String getPassword() {
        return password;
    }

    public boolean equals (User other) {
        boolean equals = false;
        if (this.users.equals(other.users)) {
            equals = true;
        }
        return equals;
    }
}





