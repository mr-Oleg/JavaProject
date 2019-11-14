package utils;

import org.hibernate.SessionFactory;

//@Controller
@Deprecated
public class MyController {
    //@GetMapping("/newUser")
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
