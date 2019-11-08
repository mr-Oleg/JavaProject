package services.implementations;

import dao.interfaces.BonusPoliciesDAO;
import models.BonusPolicies;
import services.interfaces.BonusPoliciesService;

import java.util.List;

public class BonusPoliciesServiceImpl implements BonusPoliciesService {

    private BonusPoliciesDAO bps;

    public BonusPoliciesServiceImpl(BonusPoliciesDAO bps) {
        this.bps = bps;
    }

    @Override
    public BonusPolicies findById(int id) {
        return bps.findById(id);
    }

    @Override
    public void save(BonusPolicies bp) {
        bps.save(bp);
    }

    @Override
    public void update(BonusPolicies bp) {
        bps.update(bp);
    }

    @Override
    public void delete(BonusPolicies bp) {
        bps.delete(bp);
    }

    @Override
    public List<BonusPolicies> findAll() {
        return bps.findAll();
    }
}
