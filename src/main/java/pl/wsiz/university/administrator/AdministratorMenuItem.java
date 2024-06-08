package pl.wsiz.university.administrator;

public enum AdministratorMenuItem {
    USERS_LIST(1, "lista użytkowników"),
    NEW_STUDENT(2, "dodaj nowego studenta"),
    NEW_TEACHER(3, "dodaj nowego nauczyciela"),
    NEW_ADMINISTRATOR(4, "dodaj nowego administratora"),
    EXIT(4, "wyjście z programu");

    private int nr;
    private String description;

    public static AdministratorMenuItem convert(int chosen) {
        for (AdministratorMenuItem item : values()) {
            if (item.nr == chosen) {
                return item;
            }
        }
        return EXIT;
    }

    public int getNr() {
        return nr;
    }

    public String getDescription() {
        return description;
    }

    AdministratorMenuItem(int nr, String description) {
        this.nr = nr;
        this.description = description;
    }
}
