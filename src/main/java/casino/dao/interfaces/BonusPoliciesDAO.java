package casino.dao.interfaces;

import casino.models.BonusPolicies;
import java.util.List;
@Deprecated
public interface BonusPoliciesDAO {
    BonusPolicies findById(int id);
    void save(BonusPolicies bp);
    void update(BonusPolicies bp);
    void delete(BonusPolicies bp);
    List<BonusPolicies> findAll();
}
