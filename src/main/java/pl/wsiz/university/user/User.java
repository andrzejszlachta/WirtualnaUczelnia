package pl.wsiz.university.user;

import org.mindrot.jbcrypt.BCrypt;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class User implements Serializable {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private LocalDate dateOfBirth;

    public User(String firstName, String lastName, String email, String password, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = BCrypt.hashpw(password, BCrypt.gensalt());
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public String toString() {
        return firstName + ' ' +  lastName;
    }

    public String getPassword() {
        return password;
    }

    public abstract String getRole();

}
