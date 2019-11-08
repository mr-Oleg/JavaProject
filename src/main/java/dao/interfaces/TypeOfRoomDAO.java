package dao.interfaces;
import models.*;
import java.util.List;

public interface TypeOfRoomDAO {
    TypeOfRoom findById(int id);
    void save(TypeOfRoom auth);
    void update(TypeOfRoom auth);
    void delete(TypeOfRoom auth);
    List<TypeOfRoom> findAll();
}
