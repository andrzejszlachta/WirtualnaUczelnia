package pl.wsiz.university.administrator;

import pl.wsiz.university.student.Student;
import pl.wsiz.university.user.User;
import pl.wsiz.university.user.UserAddView;
import pl.wsiz.university.user.UserRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class AdministratorAddView extends UserAddView<Administrator> {
    private UserRepository userRepository;

    public AdministratorAddView(UserRepository userRepository) {
        super(userRepository);
    }

    @Override
    protected String getTitle() {
        return "DODAWANIE ADMINISTRATORA";
    }

    @Override
    protected Administrator getUserFromInput() {
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


        Administrator administrator = new Administrator(firstName, lastName, email, pwd, date);
        return administrator;
    }
}
