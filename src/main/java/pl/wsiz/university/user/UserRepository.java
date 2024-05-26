package pl.wsiz.university.user;

import java.util.List;

public interface UserRepository {

    void insert(User user);
    List<User> findAll();

}
