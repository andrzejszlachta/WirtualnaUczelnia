package pl.wsiz.university.student;

import pl.wsiz.university.user.User;
import pl.wsiz.university.user.UserAddView;
import pl.wsiz.university.user.UserRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class StudentAddView extends UserAddView<Student> {

        private UserRepository userRepository;

        public StudentAddView(UserRepository userRepository) {
            super(userRepository);
        }

        @Override
        protected String getTitle() {
                return "DODAWANIE STUDENTA";
        }

        @Override
        protected Student getUserFromInput() {
                Scanner scanner = new Scanner(System.in);

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

                Student student = new Student(firstName, lastName, email, pwd, date, albumNumber);
                return student;
        }

}
