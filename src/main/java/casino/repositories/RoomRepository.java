package casino.repositories;

import casino.models.Room;
import org.springframework.data.repository.CrudRepository;

public interface RoomRepository extends CrudRepository<Room,Integer> {
    Room findRoomById(int id);
}
