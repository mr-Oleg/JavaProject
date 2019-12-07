package casino.controllers;

import casino.models.Room;
import casino.services.interfaces.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/demo/rooms")
public class RoomController {
    @Autowired
    private RoomService service;

    @PostMapping("/save")
    public @ResponseBody
    String save(@RequestBody Room room) {
        return service.save(room);
    }

    /*@GetMapping(path = "/show")
    public @ResponseBody
    Iterable<Room> getAll() {
        return service.findAll();
    }*/

    @GetMapping(path = "/show")
    public String getAll(Model model) {
        List<Room> rooms = (List<Room>)service.findAll();
        model.addAttribute("rooms",rooms);
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

    @GetMapping("/attach")
    public @ResponseBody
    String attach(@RequestParam(name = "roomID") Integer rID, @RequestParam(name = "userID") Integer uID) {
        return service.addUser(rID, uID);
    }

    @PostMapping("/play")
    public @ResponseBody
    String play(@RequestParam(name = "roomID") Integer rID) {
        return service.play(rID);
    }
}
