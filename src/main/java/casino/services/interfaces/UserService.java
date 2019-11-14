package casino.services.interfaces;

import casino.models.User;

public interface UserService {

    String save(User u);
    String update(User u,Integer id);
    String delete(Integer value);
    Iterable<User> findAll();
}
