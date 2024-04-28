package pl.wsiz.university;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        User user1 = new User("Adam", "Nowak", "adam@mail.com", "adam123", LocalDate.of(1990, 12, 20));
        User user2 = new User("Iwona", "Nowak", "iwona@mail.com", "iwona@33", LocalDate.of(1992, 11, 10));

        //System.out.println(user1);
        //System.out.println(user2);
        //printUser(user1);

        FileUserRepository repository = new FileUserRepository();
        repository.insert(user1);
        repository.insert(user2);
//        System.out.println(repository.findAll());
        List<User> users = repository.findAll();
//        System.out.println(users);

        LoginView loginView = new LoginView(repository);
        User loggedUser = loginView.login();

        System.out.println(loggedUser);
    }

    public static void printUser(User user) {
        System.out.println("-".repeat(35));
        System.out.println("Imię i nazwisko: " + user.getFirstName() + " " + user.getLastName());
        System.out.println("Adres email: " + user.getEmail());
        System.out.println("Data urodzenia: " + user.getDateOfBirth().format(DateTimeFormatter.ofPattern("dd MMMM uuuu")));
        System.out.println("-".repeat(35));
    }
}