package casino.services.implementations;

import casino.models.BonusPolicies;
import casino.models.User;
import casino.repositories.BonusPoliciesRepository;
import casino.response.BonusPolicyResponse;
import casino.services.interfaces.BonusPoliciesService;
import casino.services.interfaces.UserService;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;
import java.util.List;


public class BonusPoliciesServiceImplementation implements BonusPoliciesService {

    @Autowired
    private BonusPoliciesRepository bonusPoliciesRepository;
    @Autowired
    private UserService userService;
    @Autowired
    @Qualifier("mapperBonusPolicy")
    private DozerBeanMapper mapper;

    @Override
    public Iterable<BonusPolicies> findAll() {
        return bonusPoliciesRepository.findAll();
    }

    @Override
    public void attach(String login, int bonusId) {
        if (login != null && !login.equals("")) {
            BonusPolicies targetBonus = bonusPoliciesRepository.findBonusPoliciesById(bonusId);
            User targetUser = userService.findByLogin(login);
            if (targetUser != null && targetBonus != null) {
                targetUser.addBonusPolicy(targetBonus);
                targetBonus.addUser(targetUser);
                userService.saveWithNonCheck(targetUser);
            }
        }
    }

    @Override
    public void addBonus(String probability) {
        double doubleProbability = Double.parseDouble(probability);
        BonusPolicies nonTargetBonus = bonusPoliciesRepository.findBonusPoliciesByChance(doubleProbability);
        if (nonTargetBonus == null && doubleProbability <= 1.0 && doubleProbability >= 0.0) {
            BonusPolicies newBonus = new BonusPolicies();
            newBonus.setChance(doubleProbability);
            bonusPoliciesRepository.save(newBonus);
        }
    }

    @Override
    public List<BonusPolicyResponse> getBonusUser() {
        Iterable<BonusPolicies> fullSet = findAll();
        List<BonusPolicyResponse> endSet = new ArrayList<>();
        for (BonusPolicies bonusPoliciesIterator : fullSet) {
            for (User userIterator : bonusPoliciesIterator.getBonusUser()) {
                BonusPolicyResponse pageObject = new BonusPolicyResponse();
                mapper.map(bonusPoliciesIterator, pageObject);
                pageObject.setLogin(userIterator.getLogin());
                pageObject.setUserId(userIterator.getId());
                endSet.add(pageObject);
            }
        }
        return endSet;
    }

    @Override
    public void removeBonusUser(int userId, int bonusId) {
        User targetUser = userService.findUserById(userId);
        BonusPolicies targetBonusPolicy = bonusPoliciesRepository.findBonusPoliciesById(bonusId);
        if (targetUser != null && targetBonusPolicy != null) {
            targetBonusPolicy.removeUser(targetUser);
            targetUser.removeBonusPolicy(targetBonusPolicy);
            userService.saveWithNonCheck(targetUser);
        }
    }


}
