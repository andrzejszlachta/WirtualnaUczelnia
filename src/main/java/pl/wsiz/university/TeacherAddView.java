package pl.wsiz.university;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class TeacherAddView {

        private UserRepository userRepository;

        public TeacherAddView(UserRepository userRepository) {
                this.userRepository = userRepository;
        }
    public void initialize() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("===== DODAWANIE NOWEGO NAUCZYCIELA ====");
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

            System.out.print("Podaj stopień naukowy:  ");
            String degree = scanner.nextLine();

            User student = new Teacher(firstName, lastName, email, pwd, date, degree);
            userRepository.insert(student);
            System.out.println("Nauczyciel zostal dodany.");
    }
}
