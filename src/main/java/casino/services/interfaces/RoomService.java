package casino.services.interfaces;

import casino.models.Room;
import casino.models.User;

public interface RoomService {
    String save(Room r);
    String update(Room r,Integer id);
    String delete(Integer id);
    String add(User u, Integer roomId);
    Iterable<Room> findAll();
}
