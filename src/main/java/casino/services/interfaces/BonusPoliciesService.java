package casino.services.interfaces;

import casino.models.BonusPolicies;
import casino.response.BonusPolicyResponse;

import java.util.List;


public interface BonusPoliciesService {

    Iterable<BonusPolicies> findAll();

    void attach(String login, int bonusId);

    void addBonus(String probability);

    List<BonusPolicyResponse> getBonusUser();

    void removeBonusUser(int userId, int bonusId);
}
