package casino.services.interfaces;

import casino.models.TypeOfRoom;

public interface TypeOfRoomService {
    String save(TypeOfRoom tor);

    void deleteById(int id);

    Iterable<TypeOfRoom> findAll();

    TypeOfRoom findById(int id);

    void addType(int bet, String description);
}
