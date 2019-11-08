package dao.interfaces;
import models.*;
import java.util.List;

public interface RoomDAO {
    Room findById(int id);
    void save(Room auth);
    void update(Room auth);
    void delete(Room auth);
    List<Room> findAll();
}
