package casino.services.interfaces;

import casino.models.User;
import casino.response.UserResponse;

public interface UserService {

    String save(User u);

    Iterable<User> findAll();

    User findByLogin(String login);

    User findUserById(int id);

    void deleteUserById(int id);

    void setFname(String newFirstName);

    void setLname(String newLastName);

    void setPassword(String newPassword);

    void setEmail(String newEmail);

    User getCurrentUser();

    void addMoney(double payment);

    void saveWithNonCheck(User u);

    UserResponse getResponse();
}
