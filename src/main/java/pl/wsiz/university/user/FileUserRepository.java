package pl.wsiz.university.user;

import java.io.*;
import java.util.ArrayList;
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
        File file = new File("users.bin");
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        }
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Object object = null;
        try {
            object = objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        List<User> users = (List) object;
        return users;
    }
}
