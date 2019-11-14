package casino.services.implementations;

import casino.models.TypeOfRoom;
import casino.repositories.TypeOfRoomRepository;
import casino.services.interfaces.TypeOfRoomService;
import org.springframework.beans.factory.annotation.Autowired;

public class TypeOfRoomServiceImplementation implements TypeOfRoomService {

    @Autowired
    private TypeOfRoomRepository typeOfRoomRepository;

    @Override
    public String save(TypeOfRoom tor) {
        if(typeOfRoomRepository.save(tor)!=null){
            return "Saved";
        }
        return "Error!";
    }

    @Override
    public String update(TypeOfRoom tor,Integer id) {
        Iterable<TypeOfRoom> types = typeOfRoomRepository.findAll();
        for(TypeOfRoom b : types){
            if(b.getId() == id){
                b.setContribution(tor.getContribution());
                b.setDescription(tor.getDescription());
                typeOfRoomRepository.save(b);
                return "Updated";
            }
        }
        return "Not found";
    }

    @Override
    public String delete(Integer id) {
        Iterable<TypeOfRoom> types = typeOfRoomRepository.findAll();
        for (TypeOfRoom u : types) {
            if (u.getId() == id) {
                typeOfRoomRepository.delete(u);
                return "Deleted";
            }
        }
        return "Not found";
    }

    @Override
    public Iterable<TypeOfRoom> findAll() {
        return typeOfRoomRepository.findAll();
    }
}
