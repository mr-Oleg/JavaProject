package casino.services.implementations;

import casino.models.Room;
import casino.models.User;
import casino.repositories.RoleRepository;
import casino.repositories.UserRepository;
import casino.response.UserResponse;
import casino.services.interfaces.UserService;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;

public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    @Qualifier("mapperUser")
    private DozerBeanMapper dozerBeanMapper;
    @Override
    public User findByLogin(String login) {
        return userRepository.findUserByLogin(login);
    }

    @Override
    public User findUserById(int id) {
        return userRepository.findUserById(id);
    }

    @Override
    public void deleteUserById(int id) {
        userRepository.deleteUserById(id);
    }

    @Override
    public void setFname(String newFirstName) {
        User targetUser = userRepository.findUserById(getCurrentUser().getId());
        if (targetUser != null && newFirstName != null && !newFirstName.equals("")) {
            targetUser.setFirstName(newFirstName);
            userRepository.save(targetUser);
        }
    }

    @Override
    public void setLname(String newLastName) {
        User targetUser = userRepository.findUserById(getCurrentUser().getId());
        if (targetUser != null && newLastName != null && !newLastName.equals("")) {
            targetUser.setLastName(newLastName);
            userRepository.save(targetUser);
        }
    }

    @Override
    public void setPassword(String newPassword) {
        User targetUser = userRepository.findUserById(getCurrentUser().getId());
        if (targetUser != null && newPassword != null && !newPassword.equals("")) {
            targetUser.setPassword(bCryptPasswordEncoder.encode(newPassword));
            userRepository.save(targetUser);
        }
    }

    @Override
    public void setEmail(String newEmail) {
        User targetUser = userRepository.findUserById(getCurrentUser().getId());
        if (targetUser != null && newEmail != null && !newEmail.equals("")) {
            targetUser.setEmail(newEmail);
            userRepository.save(targetUser);
        }
    }

    @Override
    public User getCurrentUser() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return findByLogin(userDetails.getUsername());
    }

    public UserResponse getResponse(){
        User target = getCurrentUser();
        UserResponse outputUser = new UserResponse();
        dozerBeanMapper.map(target,outputUser);
        outputUser.setPassword("*****");
        return outputUser;
    }

    @Override
    public void addMoney(double payment) {
        User current = getCurrentUser();
        current.setBalance(current.getBalance() + payment);
        userRepository.save(current);
    }

    @Override
    public void saveWithNonCheck(User u) {
        userRepository.save(u);
    }

    @Override
    public String save(User u) {
        u.setPassword(bCryptPasswordEncoder.encode(u.getPassword()));
        u.setRole(roleRepository.findById(1).get());
        u.setDateOfSignUp(LocalDate.now());
        if (userRepository.save(u) != null) {
            return "Saved";
        }
        return "Error";
    }

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }
}
