package casino.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class HistoryRoomResponse {
    private int id;
    private String title;
    //private Date gameTime;
    private String status;
    private double benefit;
}
