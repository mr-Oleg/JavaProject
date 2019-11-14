package casino.controllers;

import casino.models.BonusPolicies;
import casino.services.interfaces.BonusPoliciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/demo/bonuspolicies")
public class BonusPoliciesController {

    @Autowired
    private BonusPoliciesService service;

    @PostMapping(path = "/save")
    public @ResponseBody
    String save(
            @RequestBody BonusPolicies bp) {
        return service.save(bp);
    }

    @GetMapping(path = "/show")
    public @ResponseBody
    Iterable<BonusPolicies> getAllUsers() {
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
    String update(@RequestBody BonusPolicies user, @PathVariable Integer id) {
        return service.update(user, id);
    }
}
