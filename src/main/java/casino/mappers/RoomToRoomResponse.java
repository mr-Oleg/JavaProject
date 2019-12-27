package casino.mappers;

import casino.models.Room;
import casino.response.RoomResponse;
import org.dozer.loader.api.BeanMappingBuilder;
import org.springframework.stereotype.Component;

@Component("RoomToRoomResponse")
public class RoomToRoomResponse extends BeanMappingBuilder {
    @Override
    protected void configure() {
        mapping(RoomResponse.class, Room.class)
                .fields("title", "title")
                .fields("occupancy", "occupancy")
                .fields("userAmount", "userAmount")
                .fields("bet", "bet")
                .fields("id", "id");
    }
}
