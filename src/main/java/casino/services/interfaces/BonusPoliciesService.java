package casino.services.interfaces;

import casino.dto.BonusPoliciesRequest;
import casino.models.BonusPolicies;


public interface BonusPoliciesService {
    String save(/*BonusPolicies*/BonusPoliciesRequest bp);
    String update(BonusPolicies bp,Integer id);
    String delete(Integer id);
    Iterable<BonusPolicies> findAll();
    String attach(Integer uID,Integer bpID);
}
