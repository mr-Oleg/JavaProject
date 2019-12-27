package casino.controllers;

import casino.models.Room;
import casino.services.interfaces.RoomService;
import casino.services.interfaces.TypeOfRoomService;
import casino.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/rooms")
public class RoomController {
    @Autowired
    private RoomService service;
    @Autowired
    private UserService userService;
    @Autowired
    private TypeOfRoomService typeOfRoomService;

    @PostMapping("/save")
    public @ResponseBody
    String save(@RequestBody Room room) {
        return service.save(room);
    }

    @GetMapping
    public String getPage(Model model){
        model.addAttribute("free", service.getFreeRooms());
        model.addAttribute("busy", service.getBusyRooms());
        model.addAttribute("user", userService.getCurrentUser());
        model.addAttribute("tor", typeOfRoomService.findAll());
        model.addAttribute("my",service.getFullRoomsForUser());
        return "rooms";
    }

    @DeleteMapping(value = "/delete/{id}")
    public @ResponseBody
    String
    delete(@PathVariable Integer id) {
        return service.delete(id);
    }

    @PutMapping("update/{id}")
    public @ResponseBody
    String update(@RequestBody Room r, @PathVariable Integer id) {
        return service.update(r, id);
    }

    @PostMapping("/add")
    public String add(Model model, @RequestParam(name = "roomID") Integer targetRoomId) {
        service.addUser(targetRoomId);
        return "redirect:/rooms";
    }

    @PostMapping("/create")
    public String create(Model model,
                         @RequestParam(name = "tor") Integer tor,
                         @RequestParam(name = "title") String title,
                         @RequestParam(name = "userAmount") Integer userAmount) {
        service.create(tor,title,userAmount);
        return "redirect:/rooms";
    }

    @PostMapping("/play")
    public String play(@RequestParam(name = "roomID") int roomId){
        service.play(roomId);
        return "redirect:/rooms";
    }
}
