package pl.wsiz.university;

import java.time.LocalDate;

public class Administrator extends User{
    public Administrator(String firstName, String lastName, String email, String password, LocalDate dateOfBirth) {
        super(firstName, lastName, email, password, dateOfBirth);
    }

    @Override
    public String getRole() {
        return "Administrator";
    }
}
