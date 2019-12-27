package casino.services.implementations;

import casino.models.*;
import casino.repositories.RoomRepository;
import casino.repositories.UserRepository;
import casino.response.RoomResponse;
import casino.services.interfaces.HistoryRoomService;
import casino.services.interfaces.RoomService;
import casino.services.interfaces.TypeOfRoomService;
import casino.services.interfaces.UserService;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class RoomServiceImplementation implements RoomService {

    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private HistoryRoomService historyRoomService;
    @Autowired
    @Qualifier("mapperRoom")
    private DozerBeanMapper dozerBeanMapper;
    @Autowired
    private TypeOfRoomService typeOfRoomService;

    @Override
    public String save(Room r) {
        Iterable<Room> rooms = roomRepository.findAll();
        for (Room test : rooms) {
            if (test.getTitle().equals(r.getTitle())) {
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
                roomRepository.deleteById(u.getId());
                return "Deleted";
            }
        }
        return "Not found";
    }

    @Override
    public void addUser(Integer roomId) {
        User targetUser = userService.getCurrentUser();
        Room targetRoom = findRoomById(roomId);
        if (targetRoom.getUserSet().size() < targetRoom.getUserAmount()) {
            if (targetUser.getBalance() >= targetRoom.getTor().getContribution()) {
                if (!isContainUser(targetUser, targetRoom)) {
                    targetRoom.setBudget(targetRoom.getBudget() + targetRoom.getTor().getContribution());
                    targetUser.setBalance(targetUser.getBalance() - targetRoom.getTor().getContribution());
                    targetRoom.addUser(targetUser);
                    targetUser.addRoom(targetRoom);
                    roomRepository.save(targetRoom);
                    userService.saveWithNonCheck(targetUser);
                }
            }

        }

    }

    @Override
    public void create(int bet, String title, int amount) {
        TypeOfRoom typeOfRoomTarget = typeOfRoomService.findById(bet);
        User targetUser = userService.getCurrentUser();
        if (isUniqueTitle(title) && typeOfRoomTarget != null && amount > 4 && amount < 11) {
            if (targetUser.getBalance() >= typeOfRoomTarget.getContribution()) {
                Room newRoom = new Room();
                newRoom.setAuthorId(targetUser.getId());//
                newRoom.setBudget(typeOfRoomTarget.getContribution());
                targetUser.setBalance(targetUser.getBalance() - typeOfRoomTarget.getContribution());
                newRoom.setTitle(title);
                newRoom.setUserAmount(amount);
                newRoom.setTor(typeOfRoomTarget);
                newRoom.addUser(targetUser);
                targetUser.addRoom(newRoom);
                roomRepository.save(newRoom);
                userService.saveWithNonCheck(targetUser);
            }
        }
    }

    public boolean isContainUser(User targetUser, Room targetRoom) {
        return targetRoom.getUserSet().contains(targetUser);
    }

    @Override
    public Iterable<Room> findAll() {
        return roomRepository.findAll();
    }

    public boolean isUniqueTitle(String title) {
        Iterable<Room> roomSet = findAll();
        for (Room RoomIterator : roomSet) {
            if (RoomIterator.getTitle().equals(title)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void play(int id) {
        Room targetRoom = findRoomById(id);
        Set<User> participants = targetRoom.getUserSet();
        User target = findUserWithBonus(participants);
        if (target != null) {
            BonusPolicies targetBonus = findMaxBonusPolicy(target);
            if (Math.random() <= targetBonus.getChance()) { // попадание в пользователя с бонусом
                target.setBalance(target.getBalance() + targetRoom.getBudget());
                HistoryRoom newHistoryRoom = new HistoryRoom();
                newHistoryRoom.setGametime(LocalDate.now());
                newHistoryRoom.setTitle(targetRoom.getTitle());
                newHistoryRoom.setWinner(target);
                for (User userIterator : targetRoom.getUserSet()) {
                    newHistoryRoom.addUser(userIterator);
                    userIterator.addHistoryRoom(newHistoryRoom);
                }
                newHistoryRoom.setTypeOfRoom(targetRoom.getTor());
                roomRepository.deleteById(targetRoom.getId());
                historyRoomService.save(newHistoryRoom);
            }
            else{
                participants.remove(target);
                Object[] endSet = participants.toArray();
                User winner = (User)endSet[(int)Math.floor(Math.random()*participants.size())];
                winner.setBalance(winner.getBalance() + targetRoom.getBudget());
                HistoryRoom newHistoryRoom = new HistoryRoom();
                newHistoryRoom.setGametime(LocalDate.now());
                newHistoryRoom.setWinner(winner);
                newHistoryRoom.setTitle(targetRoom.getTitle());
                for (User userIterator : targetRoom.getUserSet()) {
                    newHistoryRoom.addUser(userIterator);
                    userIterator.addHistoryRoom(newHistoryRoom);
                }
                newHistoryRoom.setTypeOfRoom(targetRoom.getTor());
                userService.saveWithNonCheck(winner);
                roomRepository.deleteById(targetRoom.getId());
                historyRoomService.save(newHistoryRoom);
            }
        }
        else{
            HistoryRoom newHistoryRoom = new HistoryRoom();
            newHistoryRoom.setGametime(LocalDate.now());
            newHistoryRoom.setTitle(targetRoom.getTitle());
            Object[] endSet = participants.toArray();
            User winner = (User)endSet[(int)Math.floor(Math.random()*participants.size())];
            winner.setBalance(winner.getBalance() + targetRoom.getBudget());
            newHistoryRoom.setWinner(winner);
            for (User userIterator : targetRoom.getUserSet()) {
                userIterator.addHistoryRoom(newHistoryRoom);
                newHistoryRoom.addUser(userIterator);
            }
            newHistoryRoom.setTypeOfRoom(targetRoom.getTor());
            userService.saveWithNonCheck(winner);
            roomRepository.deleteById(targetRoom.getId());
            historyRoomService.save(newHistoryRoom);
        }

    }

    private BonusPolicies findMaxBonusPolicy(User target) {
        BonusPolicies choice = null;
        double currentChance = 0.0;
        for (BonusPolicies bonusPoliciesIterator : target.getBonusPoliciesSet()) {
            if (bonusPoliciesIterator.getChance() > currentChance) {
                currentChance = bonusPoliciesIterator.getChance();
                choice = bonusPoliciesIterator;
            }
        }
        return choice;
    }

    private User findUserWithBonus(Set<User> participants) {
        for (User participant : participants) {
            Set<BonusPolicies> bonuses = participant.getBonusPoliciesSet();
            if (bonuses != null && bonuses.size() > 0) {
                return participant;
            }
        }
        return null;
    }

    @Override
    public Room findRoomById(int id) {
        return roomRepository.findRoomById(id);
    }

    @Override
    public List<RoomResponse> getFreeRooms() {
        User targetUser = userService.getCurrentUser();
        Iterable<Room> temporarySet = findAll();
        List<RoomResponse> freeSet = new ArrayList<>();
        for (Room RoomIterator : temporarySet) {
            if (!isContainUser(targetUser, RoomIterator)) {
                RoomResponse roomResponse = new RoomResponse();
                dozerBeanMapper.map(RoomIterator, roomResponse);
                freeSet.add(roomResponse);
            }
        }
        return freeSet;
    }

    @Override
    public List<RoomResponse> getBusyRooms() {
        User targetUser = userService.getCurrentUser();
        Iterable<Room> temporarySet = findAll();
        List<RoomResponse> busySet = new ArrayList<>();
        for (Room roomIterator : temporarySet) {
            if (isContainUser(targetUser, roomIterator)) {
                RoomResponse roomResponse = new RoomResponse();
                dozerBeanMapper.map(roomIterator, roomResponse);
                busySet.add(roomResponse);
            }
        }
        return busySet;
    }

    @Override
    public List<Room> getFullRooms(){
        List<Room> fullRooms = new ArrayList<>();
        Iterable<Room> allRooms = findAll();
        for(Room roomIterator : allRooms){
            if(roomIterator.getUserAmount()==roomIterator.getUserSet().size()){
                fullRooms.add(roomIterator);
            }
        }
        return fullRooms;
    }

    @Override
    public List<RoomResponse> getFullRoomsForUser() {
        List<RoomResponse> endList = new ArrayList<>();
        List<Room> allFullRooms = getFullRooms();
        for(Room roomIterator : allFullRooms){
            if(roomIterator.getAuthorId() == userService.getCurrentUser().getId()){
                RoomResponse roomResponse = new RoomResponse();
                dozerBeanMapper.map(roomIterator, roomResponse);
                endList.add(roomResponse);
            }
        }
        return endList;
    }
}
