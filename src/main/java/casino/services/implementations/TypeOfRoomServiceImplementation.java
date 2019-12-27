package casino.services.implementations;

import casino.models.TypeOfRoom;
import casino.repositories.TypeOfRoomRepository;
import casino.services.interfaces.TypeOfRoomService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class TypeOfRoomServiceImplementation implements TypeOfRoomService {

    @Autowired
    private TypeOfRoomRepository typeOfRoomRepository;

    @Override
    public String save(TypeOfRoom tor) {
        if (typeOfRoomRepository.save(tor) != null) {
            return "Saved";
        }
        return "Error!";
    }

    @Override
    public void deleteById(int id) {
        typeOfRoomRepository.deleteById(id);
    }

    @Override
    public List<TypeOfRoom> findAll() {
        List<TypeOfRoom> result = new ArrayList<>();
        typeOfRoomRepository.findAll().forEach(result::add);
        return result;
    }

    public TypeOfRoom findById(int bet) {
        return typeOfRoomRepository.findTypeOfRoomById(bet);
    }

    @Override
    public void addType(int bet, String description) {
        TypeOfRoom nonTargetType = typeOfRoomRepository.findTypeOfRoomByContribution(bet);
        if (nonTargetType == null && bet > 0) {
            TypeOfRoom typeOfRoom = new TypeOfRoom();
            typeOfRoom.setDescription(description);
            typeOfRoom.setContribution(bet);
            typeOfRoomRepository.save(typeOfRoom);
        }
    }
}
