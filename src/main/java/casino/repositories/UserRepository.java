package casino.repositories;

import casino.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {
    User findUserByLogin(String login);
    User findUserById(int id);
    void deleteUserById(int id);

}
