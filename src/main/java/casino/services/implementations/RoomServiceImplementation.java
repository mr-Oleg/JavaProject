package casino.services.implementations;

import casino.models.Room;
import casino.models.TypeOfRoom;
import casino.models.User;
import casino.repositories.RoomRepository;
import casino.repositories.UserRepository;
import casino.services.interfaces.RoomService;
import org.springframework.beans.factory.annotation.Autowired;

public class RoomServiceImplementation implements RoomService {

    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public String save(Room r) {
        if(roomRepository.save(r)!=null){
            return "Saved";
        }
        return "Error!";
    }

    @Override
    public String update(Room r,Integer val) {
        Iterable<Room> types = roomRepository.findAll();
        for(Room b : types){
            if(b.getId() == val){
                b.setBudget(r.getBudget());
                b.setTitle(r.getTitle());
                b.setTor(r.getTor());
                b.setUserAmount(r.getUserAmount());
                roomRepository.save(b);
                return "Updated";
            }
        }
        return "Not found";
    }

    @Override
    public String delete(Integer val) {
        Iterable<Room> rooms = roomRepository.findAll();
        for (Room u : rooms) {
            if (u.getId() == val) {
                roomRepository.delete(u);
                return "Deleted";
            }
        }
        return "Not found";
    }

    @Override
    public Iterable<Room> findAll() {
        return roomRepository.findAll();
    }

    public String add(User u,Integer roomId){
        userRepository.save(u);
        Iterable<Room> rooms = roomRepository.findAll();
        for (Room r : rooms) {
            if (r.getId() == roomId) {
                // надо понять, сколько народу есть уже в этой комнате
                int currentAmount = r.getUserSet().size();
                if(currentAmount < r.getUserAmount()){
                    //мы должны добавить человека в комнату и списать у него деньги со счёта,добавив их в бюджет комнаты
                    TypeOfRoom tor = r.getTor();
                    int contribution = tor.getContribution();
                    if(u.getBalance()-contribution>=0){
                        u.setBalance(u.getBalance()-contribution);
                        r.setBudget(r.getBudget()+contribution);
                        r.addUser(u);
                        u.addRoom(r);
                        roomRepository.save(r);
                        return "Successfully!";
                    }
                    return "Not enough money";
                }
                return "Room is busy";
            }
        }
        return "Room not founded";
    }
}
