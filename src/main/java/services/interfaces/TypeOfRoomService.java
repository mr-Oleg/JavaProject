package services.interfaces;

import models.TypeOfRoom;

import java.util.List;

public interface TypeOfRoomService {
    TypeOfRoom findById(int id);
    void save(TypeOfRoom tor);
    void update(TypeOfRoom tor);
    void delete(TypeOfRoom tor);
    List<TypeOfRoom> findAll();
}
