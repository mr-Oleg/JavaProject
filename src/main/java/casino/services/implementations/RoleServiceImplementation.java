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
    public String update(Role r,Integer id) {
        Iterable<Role> types = roleRepository.findAll();
        for(Role b : types){
            if(b.getId() == id){
                b.setName(r.getName());
                b.setDuties(r.getDuties());
                roleRepository.save(b);
                return "Updated";
            }
        }
        return "Not found";
    }

    @Override
    public String delete(Integer id) {
        Iterable<Role> roles = roleRepository.findAll();
        for (Role u : roles) {
            if (u.getId() == id) {
                roleRepository.delete(u);
                return "Deleted";
            }
        }
        return "Not found";
    }

    @Override
    public Iterable<Role> findAll() {
        return roleRepository.findAll();
    }
}
