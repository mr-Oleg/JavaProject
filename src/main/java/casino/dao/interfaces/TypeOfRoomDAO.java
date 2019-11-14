package casino.dao.interfaces;
import casino.models.TypeOfRoom;
import java.util.List;
@Deprecated
public interface TypeOfRoomDAO {
    TypeOfRoom findById(int id);
    void save(TypeOfRoom auth);
    void update(TypeOfRoom auth);
    void delete(TypeOfRoom auth);
    List<TypeOfRoom> findAll();
}
