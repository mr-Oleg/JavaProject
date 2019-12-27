package casino.services.implementations;

import casino.models.HistoryRoom;
import casino.models.User;
import casino.repositories.HistoryRoomRepository;
import casino.response.HistoryRoomResponse;
import casino.services.interfaces.HistoryRoomService;
import casino.services.interfaces.UserService;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class HistoryRoomServiceImplementation implements HistoryRoomService {
    @Autowired
    private HistoryRoomRepository historyRoomRepository;

    @Autowired
    private UserService userService;

    @Autowired
    @Qualifier("mapperHistoryRoom")
    private DozerBeanMapper dozerBeanMapper;

    @Override
    public String save(HistoryRoom r) {
        if (historyRoomRepository.save(r) != null) {
            return "Saved";
        }
        return "Error!";
    }

    @Override
    public Iterable<HistoryRoom> findAll() {
        return historyRoomRepository.findAll();
    }

    @Override
    public List<HistoryRoomResponse> getHistory() {
        List<HistoryRoomResponse> historyRoomResponses = new ArrayList<>();
        User targetUser = userService.getCurrentUser();
        Set<HistoryRoom> allSet = targetUser.getHistoryRooms();
        for (HistoryRoom historyRoomIterator : allSet) {
            HistoryRoomResponse historyRoomResponse = new HistoryRoomResponse();
            dozerBeanMapper.map(historyRoomIterator, historyRoomResponse);
            if (historyRoomIterator.getWinner().getId() == targetUser.getId()) {
                historyRoomResponse.setStatus("Победа");
            } else {
                historyRoomResponse.setStatus("Поражение");
            }
            historyRoomResponse.setBenefit(historyRoomIterator.getHistoryUserSet().size() * historyRoomIterator.getTypeOfRoom().getContribution());
            historyRoomResponses.add(historyRoomResponse);
        }
        return historyRoomResponses;
    }
}
