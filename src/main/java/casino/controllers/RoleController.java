package casino.controllers;

import casino.models.Role;
import casino.services.interfaces.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/demo/roles")
public class RoleController {
    @Autowired
    private RoleService service;

    @PostMapping(path = "/save")
    public @ResponseBody
    String save(
            @RequestBody Role role) {
        return service.save(role);
    }

    @GetMapping(path = "/show")
    public @ResponseBody
    Iterable<Role> getAll() {
        return service.findAll();
    }

    @DeleteMapping(value = "/delete/{id}")
    public @ResponseBody
    String
    delete(@PathVariable Integer id) {
        return service.delete(id);
    }

    @PutMapping("update/{id}")
    public @ResponseBody
    String update(@RequestBody Role role, @PathVariable Integer id) {
        return service.update(role, id);
    }
}
