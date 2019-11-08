package dao.interfaces;

import java.util.List;
import models.*;

public interface UserDAO {
    User findById(int id);
    void save(User auth);
    void update(User auth);
    void delete(User auth);
    List<User> findAll();
}
