package casino.dao.interfaces;

import java.util.List;

import casino.models.User;
@Deprecated
public interface UserDAO {
    User findById(int id);
    void save(User auth);
    void update(User auth);
    void delete(User auth);
    List<User> findAll();
}
