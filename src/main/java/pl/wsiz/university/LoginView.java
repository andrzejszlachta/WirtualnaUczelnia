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
        String email;
        String password;
        String autoLogin = System.getenv("USER_AUTOLOGIN");
        if (autoLogin != null && autoLogin.equalsIgnoreCase("true")) {
            email = System.getenv("USER_EMAIL");
            password = System.getenv("USER_PASSWORD");
        } else {
            System.out.println(autoLogin);
            Scanner scanner = new Scanner(System.in);  // Create a Scanner object
            System.out.println("========== EKRAN LOGOWANIA ==========");
            System.out.print("Podaj email: ");
            email = scanner.nextLine();
            System.out.print("Podaj hasło: ");
            password = scanner.nextLine();
        }

        List<User> users = userRepository.findAll();
        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(email) && BCrypt.checkpw(password, user.getPassword())) {
                System.out.println("Zalogowano.");
                return user;
            }
        }
        System.out.println("Dane nieprawidłowe.");
        System.out.println("========== EKRAN LOGOWANIA ==========");
        return null;
    }
}
