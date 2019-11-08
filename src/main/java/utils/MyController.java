package utils;

import dao.implementations.RoleDAOImpl;
import dao.interfaces.RoleDAO;
import models.Role;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import services.implementations.RoleServiceImpl;
import services.interfaces.RoleService;
import utils.HibernateUtil;

@Controller
public class MyController {
    @GetMapping("/newUser")
    public void greeting() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        //RoleDAO rdao = new RoleDAOImpl();
        //RoleService rserv = new RoleServiceImpl(rdao);
        //Role r = new Role("test","testduty");
        //rserv.save(r);
        sessionFactory.close();
        //model.addAttribute("name", name);
        //return "greeting";
    }

}
