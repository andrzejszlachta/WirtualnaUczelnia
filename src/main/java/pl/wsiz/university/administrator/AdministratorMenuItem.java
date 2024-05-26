package pl.wsiz.university.administrator;

public enum AdministratorMenuItem {
    USERS_LIST(1, "lista użytkowników"),
    NEW_STUDENT(2, "dodaj nowego studenta"),
    NEW_TEACHER(3, "dodaj nowego nauczyciela"),
    EXIT(4, "wyjście z programu");

    private int nr;
    private String description;

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
