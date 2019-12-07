package casino.services.implementations;

import casino.models.User;
import casino.repositories.RoleRepository;
import casino.repositories.UserRepository;
import casino.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;

public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User findByLogin(String login) {
        return userRepository.findUserByLogin(login);
    }

    @Override
    public String save(User u) {
        u.setPassword(bCryptPasswordEncoder.encode(u.getPassword()));
        u.setRole(roleRepository.findById(1).get());
        u.setDateOfSignUp(LocalDate.now());
        if(userRepository.save(u)!=null){
            return "Saved";
        }
        return "Error";
    }

    @Override
    public String update(User user, Integer id) {
        Iterable<User> users = userRepository.findAll();
        for(User u : users){
            if(u.getId() == id){
                u.setBalance(user.getBalance());
                userRepository.save(u);
                return "Updated";
            }
        }
        return "Not found";
    }

    @Override
    public String delete(Integer id) {
        Iterable<User> users = userRepository.findAll();
        for (User u : users) {
            if (u.getId() == id) {
                userRepository.delete(u);
                return "Deleted";
            }
        }
        return "Not found";
    }

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }
}
