package casino.services.implementations;

import casino.models.HistoryRoom;
import casino.repositories.HistoryRoomRepository;
import casino.services.interfaces.HistoryRoomService;
import org.springframework.beans.factory.annotation.Autowired;

public class HistoryRoomServiceImplementation implements HistoryRoomService {
    @Autowired
    private HistoryRoomRepository historyRoomRepository;

    @Override
    public String save(HistoryRoom r) {
        if(historyRoomRepository.save(r)!=null){
            return "Saved";
        }
        return "Error!";
    }

    @Override
    public String update(HistoryRoom r, Integer id) {
        Iterable<HistoryRoom> historyRooms = historyRoomRepository.findAll();
        for(HistoryRoom b : historyRooms){
            if(b.getId() == id){
                b.setTitle(r.getTitle());
                b.setTypeOfRoom(r.getTypeOfRoom());
                b.setWinner(r.getWinner());
                b.setGametime(r.getGametime());
                historyRoomRepository.save(b);
                return "Updated";
            }
        }
        return "Not found";
    }

    @Override
    public String delete(Integer id) {
        Iterable<HistoryRoom> historyRooms = historyRoomRepository.findAll();
        for (HistoryRoom u : historyRooms) {
            if (u.getId() == id) {
                historyRoomRepository.delete(u);
                return "Deleted";
            }
        }
        return "Not found";
    }

    @Override
    public Iterable<HistoryRoom> findAll() {
        return historyRoomRepository.findAll();
    }
}
