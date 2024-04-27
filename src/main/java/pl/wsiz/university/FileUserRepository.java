package pl.wsiz.university;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FileUserRepository implements UserRepository {
    @Override
    public void insert(User user) {
        List<User> users = findAll();
        users.add(user);
        File file = new File("users.bin");
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            objectOutputStream.writeObject(users);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>();
    }
}
