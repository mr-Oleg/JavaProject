package casino.dao.implementations;

import casino.dao.interfaces.RoomDAO;
import casino.models.Room;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.List;
@Deprecated
public class RoomDAOImpl implements RoomDAO {
    @Override
    public Room findById(int id) {
        return HibernateUtil.getSessionFactory().openSession().get(Room.class,id);
    }

    @Override
    public void save(Room r) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(r);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Room r) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(r);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Room r) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(r);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Room> findAll() {
        List<Room> r = (List<Room>) HibernateUtil.getSessionFactory().openSession().createQuery("From Room").list();
        return r;
    }
}
