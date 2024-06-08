package pl.wsiz.university.user;

public abstract class UserAddView<E extends User> {
    private UserRepository userRepository;

    public UserAddView(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void initialize() {
        System.out.println("===== " + getTitle() + " ====");
        E user = getUserFromInput();
        userRepository.insert(user);
        System.out.println("Użytkownik został dodany");
    }

    protected abstract String getTitle();

    protected abstract E getUserFromInput();
}

