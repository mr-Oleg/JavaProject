package casino.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TypeOfRoom")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class TypeOfRoom implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "contribution")
    private int contribution;

    @Column(name = "description")
    private String description;
    @JsonIgnore
    @OneToMany(mappedBy = "tor", orphanRemoval = true)
    private List<Room> rooms = new ArrayList<>();
    @JsonIgnore
    @OneToMany(mappedBy = "typeOfRoom", orphanRemoval = true)
    private List<HistoryRoom> historyRooms = new ArrayList<>();

    public void addToRoom(Room target){
        rooms.add(target);
    }

    public void addToHistoryRoom(HistoryRoom target){
        historyRooms.add(target);
    }
}
