package casino.services.interfaces;

import casino.models.HistoryRoom;
import casino.response.HistoryRoomResponse;

import java.util.List;

public interface HistoryRoomService {
    String save(HistoryRoom r);
    Iterable<HistoryRoom> findAll();
    List<HistoryRoomResponse> getHistory();
}
