package pl.wsiz.university;

import pl.wsiz.university.administrator.Administrator;
import pl.wsiz.university.administrator.AdministratorMenuView;
import pl.wsiz.university.student.Student;
import pl.wsiz.university.teacher.Teacher;
import pl.wsiz.university.user.FileUserRepository;
import pl.wsiz.university.user.LoginView;
import pl.wsiz.university.user.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Adam", "Nowak", "adam@mail.com", "adam123", LocalDate.of(1990, 12, 20), 95412);
        Teacher teacher1 = new Teacher("Iwona", "Nowak", "iwona@mail.com", "iwona@33", LocalDate.of(1992, 11, 10), "dr. inż.");
        Administrator administrator1 = new Administrator("Janusz", "Polak", "janusz@mail.com", "janusz", LocalDate.of(1993, 11, 13));

        //System.out.println(user1);
        //System.out.println(user2);
        //printUser(user1);

        FileUserRepository repository = new FileUserRepository();
        //repository.insert(student1);
        //repository.insert(teacher1);
        //repository.insert(administrator1);
//        System.out.println(repository.findAll());
        List<User> users = repository.findAll();
//        System.out.println(users);

        LoginView loginView = new LoginView(repository);
        User loggedUser = loginView.login();

        printUser(loggedUser);

        if (loggedUser instanceof Administrator) {
            AdministratorMenuView menu = new AdministratorMenuView(repository);
            menu.initialize();
        }
    }

    public static void printUser(User user) {
        System.out.println("-".repeat(35));
        System.out.println("Imię i nazwisko: " + user.getFirstName() + " " + user.getLastName());
        System.out.println("Adres email: " + user.getEmail());
        System.out.println("Data urodzenia: " + user.getDateOfBirth().format(DateTimeFormatter.ofPattern("dd MMMM uuuu")));
        System.out.println("Rola: " + user.getRole());
//        String rola = user.getClass().getName();
//
//        if (user instanceof  Administrator) {
//            System.out.println("Rola: Administrator");
//        } else if (user instanceof Student) {
//            System.out.println("Rola: Student");
//        } else if (user instanceof Teacher) {
//            System.out.println("Rola: Nauczyciel");
//        }

        System.out.println("-".repeat(35));
    }
}