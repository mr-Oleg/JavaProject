package casino.services.implementations;

import casino.models.BonusPolicies;
import casino.models.HistoryRoom;
import casino.models.Room;
import casino.models.User;
import casino.repositories.RoomRepository;
import casino.repositories.UserRepository;
import casino.services.interfaces.HistoryRoomService;
import casino.services.interfaces.RoomService;
import casino.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Set;

public class RoomServiceImplementation implements RoomService {

    @Autowired
    private /*RoomRepository*/RoomService roomRepository;
    @Autowired
    private /*UserRepository*/ UserService userRepository;
    @Autowired
    private HistoryRoomService historyRoomService;
    @Override
    public String save(Room r) {
        Iterable<Room> rooms = roomRepository.findAll();
        for(Room test : rooms){
           if(test.getTitle().equals(r.getTitle())){
               return "Non-unique room name";
           }
        }
        if (roomRepository.save(r) != null) {
            return "Saved";
        }
        return "Error!";
    }

    @Override
    public String update(Room r, Integer val) {
        Iterable<Room> types = roomRepository.findAll();
        for (Room b : types) {
            if (b.getId() == val) {
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
                roomRepository.delete(u.getId());
                return "Deleted";
            }
        }
        return "Not found";
    }

    @Override
    public Iterable<Room> findAll() {
        return roomRepository.findAll();
    }

    @Override
    public String play(Integer id) {
        Room room = null;
        Iterable<Room> rooms = findAll();
        for (Room r : rooms) {
            if (r.getId() == id) {
                room = r;
                break;
            }
        }
        if (room != null) {
            Set<User> users = room.getUserSet();
            BonusPolicies bonusP = null;
            User markedUser = null;
            User winner = null;
            if (users.size() == room.getUserAmount()) {
                for (User u : users) {
                    Set<BonusPolicies> bonusPolicies = u.getBonusPoliciesSet();
                    if (bonusPolicies.size() > 0) {
                        markedUser = u;
                        for (BonusPolicies bp : bonusPolicies) {
                            if (bonusP == null) {
                                bonusP = bp;
                            }
                            if (bonusP.getChance() < bp.getChance()) {
                                bonusP = bp;
                            }
                        }
                    }
                }
                if (markedUser != null) {
                    double chance = bonusP.getChance();
                    if (chance >= Math.random() * 100) {
                        winner = markedUser;
                        winner.setBalance(winner.getBalance() + room.getBudget());
                        userRepository.save(winner);
                        roomRepository.delete(room.getId());
                        return "Выиграл юзер с ником " + winner.getFirstName() + " " + winner.getLastName();
                    } else {
                        users.remove(markedUser);
                        Object[] uArray = users.toArray();
                        int winIndex = (int) (Math.random() * uArray.length);
                        winner = (User)uArray[winIndex];
                        winner.setBalance(winner.getBalance() + room.getBudget());
                        userRepository.save(winner);
                        HistoryRoom historyRoom = new HistoryRoom();
                        historyRoom.setWinner(winner);
                        historyRoom.setTypeOfRoom(room.getTor());
                        historyRoom.setGametime(LocalDate.now());
                        historyRoom.setTitle(room.getTitle());
                        Set<User> userSetForCopy = room.getUserSet();
                        for(User copier : userSetForCopy) {
                            historyRoom.addUser(copier);
                        }
                        historyRoomService.save(historyRoom);
                        roomRepository.delete(room.getId());
                        return "Выиграл юзер с ником " + winner.getFirstName() + " " + winner.getLastName();
                    }
                }
                else{
                    Object[] uArray = users.toArray();
                    int winIndex = (int) (Math.random() * uArray.length);
                    winner =(User)uArray[winIndex];
                    winner.setBalance(winner.getBalance() + room.getBudget());
                    userRepository.save(winner);
                    HistoryRoom historyRoom = new HistoryRoom();
                    historyRoom.setWinner(winner);
                    historyRoom.setTypeOfRoom(room.getTor());
                    historyRoom.setTitle(room.getTitle());
                    historyRoom.setGametime(LocalDate.now());
                    Set<User> userSetForCopy = room.getUserSet();
                    for(User copier : userSetForCopy) {
                        historyRoom.addUser(copier);
                    }
                    historyRoomService.save(historyRoom);
                    roomRepository.delete(room.getId());
                    return "Выиграл юзер с ником " + winner.getFirstName() + " " + winner.getLastName();
                }
            } else {
                return "Комната ещё не заполнилась!";
            }
        }
        return "Комната не найдена!";
    }

    @Override
    public String addUser(Integer roomId, Integer userId) {
        Room room = null;
        User user = null;
        Iterable<Room> rooms = roomRepository.findAll();
        for (Room r : rooms) {
            if (r.getId() == roomId) {
                room = r;
                break;
            }
        }
        Iterable<User> users = userRepository.findAll();
        for (User r : users) {
            if (r.getId() == userId) {
                user = r;
                break;
            }
        }
        if (room != null && user != null) {
            if (room.getUserAmount() > room.getUserSet().size()) {
                if (user.getBalance() >= room.getTor().getContribution()) {
                    user.setBalance(user.getBalance() - room.getTor().getContribution());
                    room.setBudget(room.getBudget() + room.getTor().getContribution());
                    room.addUser(user);
                    user.addRoom(room);
                    userRepository.save(user);
                    roomRepository.save(room);
                    return "Пользователь добавлен в комнату!";
                } else {
                    return "Недостаточно денег!";
                }
            } else {
                return "Комната заполнена!";
            }
        }
        return "Ошибка входных параметров!";
    }
}
