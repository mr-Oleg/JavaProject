package dao.interfaces;

import models.*;
import java.util.List;

public interface BonusPoliciesDAO {
    BonusPolicies findById(int id);
    void save(BonusPolicies bp);
    void update(BonusPolicies bp);
    void delete(BonusPolicies bp);
    List<BonusPolicies> findAll();
}
