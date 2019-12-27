package casino.repositories;

import casino.models.BonusPolicies;
import org.springframework.data.repository.CrudRepository;

public interface BonusPoliciesRepository extends CrudRepository<BonusPolicies, Integer> {
    BonusPolicies findBonusPoliciesByChance(double chance);
    BonusPolicies findBonusPoliciesById(int id);
}
