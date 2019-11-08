package services.interfaces;

import models.User;

import java.util.List;

public interface UserService {
    User findById(int id);
    void save(User u);
    void update(User u);
    void delete(User u);
    List<User> findAll();
}
