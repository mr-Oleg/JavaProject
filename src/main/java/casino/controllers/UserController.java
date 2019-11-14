package casino.controllers;

import casino.models.User;
import casino.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(path = "/show")
    public @ResponseBody
    Iterable<User> getAllUsers() {
        return service.findAll();
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
}
