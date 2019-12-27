package casino.services.interfaces;

import casino.models.Role;


public interface RoleService {
    String save(Role r);
    Iterable<Role> findAll();
}
