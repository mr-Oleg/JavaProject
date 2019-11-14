package casino.controllers;

import casino.models.TypeOfRoom;
import casino.services.interfaces.TypeOfRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/demo/typeofrooms")
public class TypeOfRoomController {
    @Autowired
    private TypeOfRoomService service;

    @PostMapping(path = "/save")
    public @ResponseBody
    String save(
            @RequestBody TypeOfRoom tor) {
        return service.save(tor);
    }

    @GetMapping(path = "/show")
    public @ResponseBody
    Iterable<TypeOfRoom> getAll() {
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
    String update(@RequestBody TypeOfRoom tor, @PathVariable Integer id) {
        return service.update(tor, id);
    }
}
