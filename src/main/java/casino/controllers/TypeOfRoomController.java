package casino.controllers;

import casino.models.TypeOfRoom;
import casino.services.interfaces.TypeOfRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

//    @GetMapping(path = "/show")
//    public @ResponseBody
//    Iterable<TypeOfRoom> getAll() {
//        return service.findAll();
//    }

    @GetMapping(path = "/show")
    public String getAll(Model model) {
        List<TypeOfRoom> tor = (List<TypeOfRoom>) service.findAll();
        model.addAttribute("tor",tor);
        return "typeofrooms";
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
