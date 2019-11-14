package casino.services.implementations;

import casino.models.BonusPolicies;
import casino.repositories.BonusPoliciesRepository;
import casino.services.interfaces.BonusPoliciesService;
import org.springframework.beans.factory.annotation.Autowired;


public class BonusPoliciesServiceImplementation implements BonusPoliciesService {

    @Autowired
    private BonusPoliciesRepository bonusPoliciesRepository;

    @Override
    public String save(BonusPolicies bp) {
        if(bonusPoliciesRepository.save(bp)!=null){
            return "Saved";
        }
        return "Error!";
    }

    @Override
    public String update(BonusPolicies bp, Integer id) {
        Iterable<BonusPolicies> policies = bonusPoliciesRepository.findAll();
        for(BonusPolicies b : policies){
            if(b.getId() == id){
                b.setChance(bp.getChance());
                bonusPoliciesRepository.save(b);
                return "Updated";
            }
        }
        return "Not found";
    }

    @Override
    public String delete(Integer id) {
        Iterable<BonusPolicies> users = bonusPoliciesRepository.findAll();
        for (BonusPolicies u : users) {
            if (u.getId() == id) {
                bonusPoliciesRepository.delete(u);
                return "Deleted";
            }
        }
        return "Not found";
    }

    @Override
    public Iterable<BonusPolicies> findAll() {
        return bonusPoliciesRepository.findAll();
    }
}
