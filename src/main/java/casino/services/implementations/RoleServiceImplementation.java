package casino.services.implementations;

import casino.models.Role;
import casino.repositories.RoleRepository;
import casino.services.interfaces.RoleService;
import org.springframework.beans.factory.annotation.Autowired;

public class RoleServiceImplementation implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public String save(Role r) {
        if(roleRepository.save(r)!=null){
            return "Saved";
        }
        return "Error!";
    }

    @Override
    public Iterable<Role> findAll() {
        return roleRepository.findAll();
    }
}
