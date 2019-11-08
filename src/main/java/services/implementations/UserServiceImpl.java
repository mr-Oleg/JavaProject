package services.implementations;

import dao.interfaces.UserDAO;
import models.User;
import services.interfaces.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDAO udao;

    public UserServiceImpl(UserDAO udao){
        this.udao = udao;
    }

    @Override
    public User findById(int id) {
        return udao.findById(id);
    }

    @Override
    public void save(User u) {
        udao.save(u);
    }

    @Override
    public void update(User u) {
        udao.update(u);
    }

    @Override
    public void delete(User u) {
        udao.delete(u);
    }

    @Override
    public List<User> findAll() {
        return udao.findAll();
    }
}
