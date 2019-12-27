package casino.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class RoomResponse implements Serializable {
    private int id;
    private String title;
    private int occupancy;
    private int userAmount;
    private int bet;
}
