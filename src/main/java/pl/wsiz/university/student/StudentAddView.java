package pl.wsiz.university.student;

import pl.wsiz.university.user.User;
import pl.wsiz.university.user.UserRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class StudentAddView {

        private UserRepository userRepository;

        public StudentAddView(UserRepository userRepository) {
                this.userRepository = userRepository;
        }
    public void initialize() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("===== DODAWANIE NOWEGO STUDENTA ====");

            System.out.print("Podaj imię:  ");
            String firstName = scanner.nextLine();
            System.out.print("Podaj nazwisko:  ");
            String lastName = scanner.nextLine();
            System.out.print("Podaj email:  ");
            String email = scanner.nextLine();
            System.out.print("Podaj hasło:  ");
            String pwd = scanner.nextLine();
            System.out.print("Podaj datę urodzenia (yyyy-mm-dd):  ");
            String dateOfBirth = scanner.nextLine();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            formatter = formatter.withLocale(Locale.ENGLISH);
            LocalDate date = LocalDate.parse(dateOfBirth, formatter);

            System.out.print("Podaj nr albumu:  ");
            Long albumNumber = scanner.nextLong();

            User student = new Student(firstName, lastName, email, pwd, date, albumNumber);
            userRepository.insert(student);
            System.out.println("Student zostal dodany.");
    }
}
