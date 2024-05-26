package pl.wsiz.university.user;

import java.util.Comparator;
import java.util.List;

public class UserListView {
    private final UserRepository userRepository;

    public UserListView(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void initialize() {
        System.out.println("=== LISTA UŻYTKOWNIKÓW ===");
        System.out.println(withSpaces("Imię", 20) + withSpaces("Nazwisko", 20) + withSpaces("Email", 32) + withSpaces("Rola", 20));
        List<User> users = userRepository.findAll();
        users.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                int compareOfLastNames = o1.getLastName().compareTo(o2.getLastName());
                if (compareOfLastNames == 0) {
                    return o1.getFirstName().compareTo(o2.getFirstName());
                }
                return compareOfLastNames;
            }
        });
        for (User user : users) {
            System.out.println(withSpaces(user.getFirstName(), 20) + withSpaces(user.getLastName(), 20) + withSpaces(user.getEmail(), 32) + withSpaces(user.getRole(), 20));
        }
    }

    public String withSpaces(String text, int maxLength) {
        return (maxLength > text.length()) ? text + " ".repeat(maxLength - text.length()) : text;
    }
}
