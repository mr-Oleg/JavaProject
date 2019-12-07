package casino.controllers;

import casino.models.HistoryRoom;
import casino.services.interfaces.HistoryRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/demo/historyroom")
public class HistoryRoomController {

    @Autowired
    HistoryRoomService service;

    @PostMapping(path = "/save")
    public @ResponseBody
    String save(
            @RequestBody HistoryRoom historyRoom) {
        return service.save(historyRoom);
    }


    @GetMapping(path = "/show")
    public String getAll(Model model) {
        List<HistoryRoom> roles = (List<HistoryRoom>)service.findAll();
        model.addAttribute("historyroom",roles);
        return "historyroom";
    }

    @DeleteMapping(value = "/delete/{id}")
    public @ResponseBody
    String
    delete(@PathVariable Integer id) {
        return service.delete(id);
    }

    @PutMapping("update/{id}")
    public @ResponseBody
    String update(@RequestBody HistoryRoom historyRoom, @PathVariable Integer id) {
        return service.update(historyRoom, id);
    }
}
