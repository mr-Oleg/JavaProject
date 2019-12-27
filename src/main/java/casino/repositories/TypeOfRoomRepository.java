package casino.repositories;

import casino.models.TypeOfRoom;
import org.springframework.data.repository.CrudRepository;

public interface TypeOfRoomRepository extends CrudRepository<TypeOfRoom,Integer> {
    TypeOfRoom findTypeOfRoomById(int id);
    TypeOfRoom findTypeOfRoomByContribution(int bet);
    void deleteTypeOfRoomById(int id);
}
