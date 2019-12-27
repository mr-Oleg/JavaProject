package casino.mappers;

import casino.models.HistoryRoom;
import casino.response.HistoryRoomResponse;
import org.dozer.loader.api.BeanMappingBuilder;
import org.springframework.stereotype.Component;

@Component("HistoryRoomToHistoryRoomResponse")
public class HistoryRoomToHistoryRoomResponse extends BeanMappingBuilder {
    @Override
    protected void configure() {
        mapping(HistoryRoomResponse.class, HistoryRoom.class)
                .fields("title", "title")
                .fields("id", "id");
    }
}
