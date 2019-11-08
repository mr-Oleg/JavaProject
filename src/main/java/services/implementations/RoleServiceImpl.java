package services.implementations;

import dao.interfaces.RoleDAO;
import models.Role;
import services.interfaces.RoleService;

import java.util.List;

public class RoleServiceImpl implements RoleService {

    private RoleDAO rdao;

    public RoleServiceImpl(RoleDAO rdao) {
        this.rdao = rdao;
    }

    @Override
    public Role findById(int id) {
        return rdao.findById(id);
    }

    @Override
    public void save(Role r) {
        rdao.save(r);
    }

    @Override
    public void update(Role r) {
        rdao.update(r);
    }

    @Override
    public void delete(Role r) {
        rdao.delete(r);
    }

    @Override
    public List<Role> findAll() {
        return rdao.findAll();
    }
}
