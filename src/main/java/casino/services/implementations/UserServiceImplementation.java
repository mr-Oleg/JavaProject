package casino.services.implementations;

import casino.models.User;
import casino.repositories.UserRepository;
import casino.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public String save(User u) {
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
