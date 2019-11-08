package dao.interfaces;
import models.*;
import java.util.List;

public interface RoleDAO {
    Role findById(int id);
    void save(Role auth);
    void update(Role auth);
    void delete(Role auth);
    List<Role> findAll();
}
