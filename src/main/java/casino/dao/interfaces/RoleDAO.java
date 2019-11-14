package casino.dao.interfaces;
import casino.models.Role;
import java.util.List;
@Deprecated
public interface RoleDAO {
    Role findById(int id);
    void save(Role auth);
    void update(Role auth);
    void delete(Role auth);
    List<Role> findAll();
}
