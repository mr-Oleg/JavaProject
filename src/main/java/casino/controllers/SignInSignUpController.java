package casino.controllers;

import casino.models.User;
import casino.services.interfaces.SecurityService;
import casino.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignInSignUpController {

    @Autowired
    private UserService service;

    @Autowired
    private SecurityService securityService;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        //userValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        System.out.println(userForm + "- userform");
        service.save(userForm);
        securityService.autoLogin(userForm.getLogin(), userForm.getPassword());
        return "users";
    }

    /*@GetMapping("/login")
    public String login(Model model, String error, String logout) {
        //model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("login")
    public String formPost(@ModelAttribute("user") User user, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            return "users";
        }
        securityService.autoLogin(user.getLogin(), user.getPassword());
        return "/demo/rooms/show";
    }*/

}
