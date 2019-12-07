package casino.services.implementations;

import casino.dto.BonusPoliciesRequest;
import casino.models.BonusPolicies;
import casino.models.User;
import casino.repositories.BonusPoliciesRepository;
import casino.repositories.UserRepository;
import casino.services.interfaces.BonusPoliciesService;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;


public class BonusPoliciesServiceImplementation implements BonusPoliciesService {

    @Autowired
    private BonusPoliciesRepository bonusPoliciesRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DozerBeanMapper mapper;

    @Override
    public String save(/*BonusPolicies*/BonusPoliciesRequest bp) {

        /*if(bonusPoliciesRepository.save(bp)!=null){
            return "Saved";
        }
        return "Error!";*/
        if(bp != null){
            BonusPolicies bonusPolicies = mapper.map(bp,BonusPolicies.class);
            bonusPoliciesRepository.save(bonusPolicies);
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

    @Override
    public String attach(Integer uID, Integer bpID) {
        User u = null;
        Iterable<User> users = userRepository.findAll();
        for(User us : users){
            if(us.getId() == uID){
                u = us;
            }
        }
        Iterable<BonusPolicies> bp = findAll();
        BonusPolicies checked = null;
        for(BonusPolicies b : bp){
            if(b.getId()==bpID){
                checked = b;
            }
        }
        if(checked != null && u != null){
            u.addBonusPolicy(checked);
            checked.addUser(u);
            bonusPoliciesRepository.save(checked);
            userRepository.save(u);
            return "Attached!";
        }
        return "Unattached!";
    }
}
