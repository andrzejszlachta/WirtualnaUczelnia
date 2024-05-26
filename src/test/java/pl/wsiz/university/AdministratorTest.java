package pl.wsiz.university;

import org.junit.jupiter.api.Test;
import pl.wsiz.university.administrator.Administrator;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AdministratorTest {

    @Test
    void getFirstName() {
        Administrator administrator1 = new Administrator("Adam", "Nowak", "adam@mail.com", "adam123", LocalDate.of(1990, 12, 20));

        String firstName = administrator1.getFirstName();
        String lastName = administrator1.getLastName();
        String email = administrator1.getEmail();

        assertEquals("Adam", firstName);
        assertEquals("Nowak", lastName);
        assertEquals("adam@mail.com", email);
    }
}