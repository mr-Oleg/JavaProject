package casino.services.interfaces;

import casino.models.Room;
import casino.models.User;

public interface RoomService {
    String save(Room r);
    String update(Room r,Integer id);
    String delete(Integer id);
    String addUser(Integer roomId,Integer userId);
    Iterable<Room> findAll();
    String play(Integer id);
}
