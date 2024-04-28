package pl.wsiz.university;

import org.mindrot.jbcrypt.BCrypt;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class LoginView {
    private final UserRepository userRepository;

    public LoginView(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User login() {
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        System.out.println("========== EKRAN LOGOWANIA ==========");
        System.out.print("Podaj email: ");
        String email = scanner.nextLine();
        System.out.print("Podaj hasło: ");
        String pwd = scanner.nextLine();

        List<User> users = userRepository.findAll();
        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(email) && BCrypt.checkpw(pwd, user.getPassword())) {
                System.out.println("Zalogowano.");
                return user;
            }
        }
        System.out.println("Dane nieprawidłowe.");
        System.out.println("========== EKRAN LOGOWANIA ==========");
        return null;
    }
}
