package casino.dao.implementations;

import casino.dao.interfaces.BonusPoliciesDAO;
import casino.models.BonusPolicies;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.List;
@Deprecated
public class BonusPoliciesDAOImpl implements BonusPoliciesDAO {
    @Override
    public BonusPolicies findById(int id) {
        return HibernateUtil.getSessionFactory().openSession().get(BonusPolicies.class, id);
    }

    @Override
    public void save(BonusPolicies bp) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(bp);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(BonusPolicies bp) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(bp);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(BonusPolicies bp) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(bp);
        transaction.commit();
        session.close();
    }

    @Override
    public List<BonusPolicies> findAll() {
        List<BonusPolicies> bp = (List<BonusPolicies>) HibernateUtil.getSessionFactory().openSession().createQuery("From BonusPolicies").list();
        return bp;
    }
}
