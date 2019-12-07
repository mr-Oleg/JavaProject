package casino.services.interfaces;

import casino.models.HistoryRoom;

public interface HistoryRoomService {
    String save(HistoryRoom r);
    String update(HistoryRoom r,Integer id);
    String delete(Integer id);
    Iterable<HistoryRoom> findAll();
}
