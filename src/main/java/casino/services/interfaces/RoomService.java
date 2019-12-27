package casino.services.interfaces;

import casino.models.Room;
import casino.models.User;
import casino.response.RoomResponse;

import java.util.List;

public interface RoomService {
    String save(Room r);
    String update(Room r,Integer id);
    String delete(Integer id);
    void addUser(Integer roomId);
    void create(int bet,String title,int amount);
    Iterable<Room> findAll();
    void play(int id);
    Room findRoomById(int id);
    List<RoomResponse> getFreeRooms();
    List<RoomResponse> getBusyRooms();
    List<Room> getFullRooms();
    List<RoomResponse> getFullRoomsForUser();
}
