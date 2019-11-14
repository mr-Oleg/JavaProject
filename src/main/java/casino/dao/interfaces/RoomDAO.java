package casino.dao.interfaces;
import casino.models.Room;
import java.util.List;
@Deprecated
public interface RoomDAO {
    Room findById(int id);
    void save(Room auth);
    void update(Room auth);
    void delete(Room auth);
    List<Room> findAll();
}
