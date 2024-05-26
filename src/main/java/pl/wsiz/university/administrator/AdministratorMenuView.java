package pl.wsiz.university.administrator;

import pl.wsiz.university.student.StudentAddView;
import pl.wsiz.university.teacher.TeacherAddView;
import pl.wsiz.university.user.UserListView;
import pl.wsiz.university.user.UserRepository;

import java.util.Scanner;

public class AdministratorMenuView {
    private UserRepository userRepository;

    public AdministratorMenuView(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void initialize() {
        int chosen;
        do {
            System.out.println("===== MENU ADMINISTRATORA ====");
            for (AdministratorMenuItem item : AdministratorMenuItem.values()) {
                System.out.println(item.getNr() + " - " + item.getDescription());
            }
            System.out.println("Co wybierasz? ");
            Scanner scanner = new Scanner(System.in);
            chosen = scanner.nextInt();
            if (chosen == AdministratorMenuItem.USERS_LIST.getNr()) {
                new UserListView(userRepository).initialize();
            } else if (chosen == AdministratorMenuItem.NEW_STUDENT.getNr()) {
                new StudentAddView(userRepository).initialize();
            } else if (chosen == AdministratorMenuItem.NEW_TEACHER.getNr()) {
                new TeacherAddView(userRepository).initialize();
            }
        } while (chosen != AdministratorMenuItem.EXIT.getNr());

    }



}
