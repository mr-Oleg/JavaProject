package casino.controllers;

import casino.models.Room;
import casino.models.User;
import casino.services.interfaces.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/demo/rooms")
public class RoomController {
    @Autowired
    private RoomService service;

    @PostMapping(path = "/save")
    public @ResponseBody
    String save(
            @RequestBody Room r) {
        return service.save(r);
    }

    @PostMapping("/add/{id}")
    public @ResponseBody
    String addUser(
            @RequestBody User u,@PathVariable Integer id) {
        return service.add(u,id);
    }

    @GetMapping(path = "/show")
    public @ResponseBody
    Iterable<Room> getAll() {
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
    String update(@RequestBody Room r, @PathVariable Integer id) {
        return service.update(r, id);
    }
}
