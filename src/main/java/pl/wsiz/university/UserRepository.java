package pl.wsiz.university;

import java.util.List;

public interface UserRepository {

    void insert(User user);
    List<User> findAll();

}
