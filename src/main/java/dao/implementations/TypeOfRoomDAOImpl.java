package dao.implementations;

import dao.interfaces.TypeOfRoomDAO;
import models.TypeOfRoom;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.List;

public class TypeOfRoomDAOImpl implements TypeOfRoomDAO {
    @Override
    public TypeOfRoom findById(int id) {
        return HibernateUtil.getSessionFactory().openSession().get(TypeOfRoom.class,id);
    }

    @Override
    public void save(TypeOfRoom tor) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(tor);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(TypeOfRoom tor) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(tor);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(TypeOfRoom tor) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(tor);
        transaction.commit();
        session.close();
    }

    @Override
    public List<TypeOfRoom> findAll() {
        List<TypeOfRoom> tor = (List<TypeOfRoom>) HibernateUtil.getSessionFactory().openSession().createQuery("From TypeOfRoom").list();
        return tor;
    }
}
