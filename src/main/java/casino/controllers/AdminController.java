package casino.controllers;

import casino.services.interfaces.BonusPoliciesService;
import casino.services.interfaces.RoomService;
import casino.services.interfaces.TypeOfRoomService;
import casino.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/admin")
@PreAuthorize("hasAuthority('admin')")
public class AdminController {

    @Autowired
    private RoomService roomService;

    @Autowired
    private UserService userService;

    @Autowired
    private BonusPoliciesService bonusPoliciesService;

    @Autowired
    private TypeOfRoomService typeOfRoomService;

    @PostMapping("/play")
    public String play(@RequestParam(name = "roomID") int roomId) {
        roomService.play(roomId);
        return "redirect:/admin/games";
    }

    @PreAuthorize("hasAuthority('admin')")
    @GetMapping("/games")
    public String getGames(Model model) {
        model.addAttribute("rooms", roomService.getFullRooms());
        model.addAttribute("user",userService.getCurrentUser());
        model.addAttribute("types",typeOfRoomService.findAll());
        return "games";
    }

    @PreAuthorize("hasAuthority('admin')")
    @GetMapping("/bonuses")
    public String getBonuses(Model model) {
        model.addAttribute("rooms", roomService.getFullRooms());
        model.addAttribute("user",userService.getCurrentUser());
        model.addAttribute("bonuses",bonusPoliciesService.findAll());
        model.addAttribute("bonusUser",bonusPoliciesService.getBonusUser());
        return "bonuses";
    }

    @PostMapping("/addbonus")
    public String addBonus(@RequestParam(name = "probability") String probability){
        bonusPoliciesService.addBonus(probability);
        return "redirect:/admin/bonuses";
    }

    @PostMapping("/association")
    public String appoint(@RequestParam(name = "login") String login,@RequestParam(name = "chance") int bonusId) {
        bonusPoliciesService.attach(login,bonusId);
        return "redirect:/admin/bonuses";
    }

    @PostMapping("/remove")
    public String removeBonusUser(@RequestParam(name = "userId") int userId,@RequestParam(name = "bonusId") int bonusId) {
        bonusPoliciesService.removeBonusUser(userId,bonusId);
        return "redirect:/admin/bonuses";
    }

    @PostMapping("/addtype")
    public String addRoomType(@RequestParam(name = "bet") int bet,@RequestParam(name = "description") String description){
        typeOfRoomService.addType(bet,description);
        return "redirect:/admin/games";
    }

    @PostMapping("/removeType")
    public String removeType(@RequestParam(name = "typeID") int id){
        typeOfRoomService.deleteById(id);
        return "redirect:/admin/games";
    }
}
