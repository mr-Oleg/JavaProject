package services.interfaces;

import models.BonusPolicies;

import java.util.List;

public interface BonusPoliciesService {
    BonusPolicies findById(int id);
    void save(BonusPolicies bp);
    void update(BonusPolicies bp);
    void delete(BonusPolicies bp);
    List<BonusPolicies> findAll();
}
