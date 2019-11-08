package services.interfaces;

import models.Role;

import java.util.List;

public interface RoleService {
    Role findById(int id);
    void save(Role r);
    void update(Role r);
    void delete(Role r);
    List<Role> findAll();
}
