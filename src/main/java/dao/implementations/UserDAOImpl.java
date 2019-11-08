package dao.implementations;

import dao.interfaces.UserDAO;
import models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.List;

public class UserDAOImpl implements UserDAO {
    @Override
    public User findById(int id) {
        return HibernateUtil.getSessionFactory().openSession().get(User.class, id);
    }

    @Override
    public void save(User u) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(u);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(User u) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(u);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(User u) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(u);
        transaction.commit();
        session.close();
    }

    @Override
    public List<User> findAll() {
        List<User> u = (List<User>) HibernateUtil.getSessionFactory().openSession().createQuery("From User").list();
        return u;
    }
}
