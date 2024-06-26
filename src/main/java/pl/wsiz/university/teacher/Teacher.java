package pl.wsiz.university.teacher;

import pl.wsiz.university.user.User;

import java.time.LocalDate;

public class Teacher extends User {
    private String academicDegree;

    public Teacher(String firstName, String lastName, String email, String password, LocalDate dateOfBirth, String academicDegree) {
        super(firstName, lastName, email, password, dateOfBirth);
        this.academicDegree = academicDegree;
    }

    @Override
    public String getRole() {
        return "Nauczyciel";
    }
}
