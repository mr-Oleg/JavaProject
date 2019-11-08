package utils;

import dao.implementations.*;
import dao.interfaces.*;
import models.*;
import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import services.implementations.*;
import services.interfaces.*;

import java.time.LocalDate;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
//        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//        RoleDAO rdao = new RoleDAOImpl();
//        UserDAO udao = new UserDAOImpl();
//        RoleService rserv = new RoleServiceImpl(rdao);
//        UserService userv = new UserServiceImpl(udao);
//        Role r = new Role("test1","testduty1");
//        User u = new User("1","2","3","4","5",LocalDate.now(),LocalDate.now(),5000.0,r);
//        rserv.save(r);
//        userv.save(u);
//        sessionFactory.close();
    }

}
