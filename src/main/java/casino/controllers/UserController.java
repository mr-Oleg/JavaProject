package casino.controllers;

import casino.models.User;
import casino.services.interfaces.HistoryRoomService;
import casino.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/personal")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private HistoryRoomService historyRoomService;

    @PostMapping(path = "/save")
    public @ResponseBody
    String save(
            @RequestBody User user) {
        return service.save(user);
    }

    @GetMapping
    public String getAll(Model model) {
        service.getCurrentUser();
        model.addAttribute("user", service.getResponse());
        model.addAttribute("history", historyRoomService.getHistory());
        return "personal";
    }

    @DeleteMapping(value = "/delete/{id}")
    public void
    delete(@PathVariable Integer id) {
        service.deleteUserById(id);
    }

    @PostMapping(value = "/fname")
    public String setFname(@RequestParam(name = "fname") String newFirstName) {
        service.setFname(newFirstName);
        return "redirect:/personal";
    }

    @PostMapping(value = "/lname")
    public String setLname(@RequestParam(name = "lname") String newLastName) {
        service.setLname(newLastName);
        return "redirect:/personal";
    }

    @PostMapping(value = "/password")
    public String setPassword(@RequestParam(name = "password") String newPassword) {
        service.setPassword(newPassword);
        return "redirect:/personal";
    }

    @PostMapping(value = "/email")
    public String setEmail(@RequestParam(name = "email") String newEmail) {
        service.setEmail(newEmail);
        return "redirect:/personal";
    }

    @PostMapping(value = "/addmoney")
    public String addMoney(@RequestParam(name = "money") double payment) {
        service.addMoney(payment);
        return "redirect:/personal";
    }
}
