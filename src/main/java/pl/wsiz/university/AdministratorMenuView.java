package pl.wsiz.university;

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
            }
        } while (chosen != AdministratorMenuItem.EXIT.getNr());

    }



}
