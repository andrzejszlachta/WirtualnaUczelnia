package pl.wsiz.university;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void getFirstName() {
        User user1 = new User("Adam", "Nowak", "adam@mail.com", "adam123", LocalDate.of(1990, 12, 20));

        String firstName = user1.getFirstName();
        String lastName = user1.getLastName();
        String email = user1.getEmail();

        assertEquals("Adam", firstName);
        assertEquals("Nowak", lastName);
        assertEquals("adam@mail.com", email);
    }
}