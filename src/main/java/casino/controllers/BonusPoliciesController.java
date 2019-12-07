package casino.controllers;

import casino.dto.BonusPoliciesRequest;
import casino.models.BonusPolicies;
import casino.services.interfaces.BonusPoliciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/demo/bonuspolicies")
public class BonusPoliciesController {

    @Autowired
    private BonusPoliciesService service;

    @PostMapping(path = "/save")
    public @ResponseBody
    String save(
            @RequestBody /*BonusPolicies*/BonusPoliciesRequest bp) {
        return service.save(bp);
    }

//    @GetMapping(path = "/show")
//    public @ResponseBody
//    Iterable<BonusPolicies> getAllUsers() {
//        return service.findAll();
//    }

    @GetMapping(path = "/show")
    public String getAllUsers(Model model){
        List<BonusPolicies> bp = (List<BonusPolicies>)service.findAll();
        model.addAttribute("bp",bp);
        return "bonuspolicies";
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

    @GetMapping(path = "/attach")
    public @ResponseBody String attach(@RequestParam(name = "userID") Integer uID,@RequestParam(name = "bpID") Integer bpID){
        return service.attach(uID,bpID);
    }
}
