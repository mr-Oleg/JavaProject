package casino.services.interfaces;

import casino.models.BonusPolicies;


public interface BonusPoliciesService {
    String save(BonusPolicies bp);
    String update(BonusPolicies bp,Integer id);
    String delete(Integer id);
    Iterable<BonusPolicies> findAll();
}
