package entity;


import javax.management.relation.Role;
import java.util.List;

public class User {

private long id;

private String firstName;

private String lastName;

private String email;

private String password;

private Role role;

private List<Transaction> transactions;

    public User() {
    }

    public User(long id, String firstName, String lastName,
                String email, String password, Role role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role;
    }

}
