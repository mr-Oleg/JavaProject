package casino.services.interfaces;

import casino.models.TypeOfRoom;

public interface TypeOfRoomService {
    String save(TypeOfRoom tor);
    String update(TypeOfRoom tor,Integer id);
    String delete(Integer id);
    Iterable<TypeOfRoom> findAll();
}
