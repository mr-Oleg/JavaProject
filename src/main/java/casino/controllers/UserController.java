package casino.controllers;

import casino.models.User;
import casino.services.interfaces.SecurityService;
import casino.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(path = "/demo/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping(path = "/save")
    public @ResponseBody
    String save(
            @RequestBody User user) {
        return service.save(user);
    }

    /*@GetMapping(path = "/show")
    public @ResponseBody
    Iterable<User> getAllUsers() {
        return service.findAll();
    }*/

    @GetMapping(path = "/show")
    public String getAll(Model model) {
        List<User> rooms = (List<User>)service.findAll();
        model.addAttribute("users",rooms);
        return "users";
    }

    @DeleteMapping(value = "/delete/{id}")
    public @ResponseBody
    String
    deleteStudent(@PathVariable Integer id) {
        return service.delete(id);
    }

    @PutMapping("update/{id}")
    public @ResponseBody
    String update(@RequestBody User user, @PathVariable Integer id) {
        return service.update(user, id);
    }

    @RequestMapping("/index")
    public String test(Model model){
        model.addAttribute("name","Hello");
        return "index";
    }

}
