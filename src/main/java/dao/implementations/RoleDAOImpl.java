package dao.implementations;

import dao.interfaces.RoleDAO;
import models.Role;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.List;

public class RoleDAOImpl implements RoleDAO {
    @Override
    public Role findById(int id) {
        return HibernateUtil.getSessionFactory().openSession().get(Role.class,id);
    }

    @Override
    public void save(Role auth) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(auth);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Role auth) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(auth);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Role auth) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(auth);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Role> findAll(){
        List<Role> roles = (List<Role>) HibernateUtil.getSessionFactory().openSession().createQuery("From Role").list();
        return roles;
    }
}
