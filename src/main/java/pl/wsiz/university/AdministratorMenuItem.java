package pl.wsiz.university;

public enum AdministratorMenuItem {
    USERS_LIST(1, "lista użytkowników"),
    EXIT(2, "wyjście z programu");

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
