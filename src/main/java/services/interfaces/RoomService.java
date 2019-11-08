package services.interfaces;

import models.Room;

import java.util.List;

public interface RoomService {
    Room findById(int id);
    void save(Room r);
    void update(Room r);
    void delete(Room r);
    List<Room> findAll();
}
