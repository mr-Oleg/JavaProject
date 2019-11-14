package casino.services.interfaces;

import casino.models.Role;


public interface RoleService {
    String save(Role r);
    String update(Role r,Integer id);
    String delete(Integer id);
    Iterable<Role> findAll();
}
