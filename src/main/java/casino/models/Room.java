package casino.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.dozer.Mapping;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Room")
@Getter
@Setter
@NoArgsConstructor
@ToString
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Room implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private double budget;
    private int userAmount;
    private int authorId;//
    @ManyToMany
    @JoinTable(
            name = "UserSet",
            joinColumns = {@JoinColumn(name = "room_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private Set<User> userSet = new HashSet<User>();
    @ManyToOne(fetch = FetchType.EAGER)//cascade = {CascadeType.ALL}
    @JoinColumn(name = "TypeOfRoom")
    private TypeOfRoom tor;

    public void addUser(User user) {
        userSet.add(user);
    }

    public void removeUser(User user) {
        userSet.remove(user);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room)) return false;
        Room room = (Room) o;
        return getId() == room.getId() &&
                Double.compare(room.getBudget(), getBudget()) == 0 &&
                getUserAmount() == room.getUserAmount() &&
                getTitle().equals(room.getTitle()) &&
                getTor().equals(room.getTor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getBudget(), getUserAmount(), getTor());
    }

    @Mapping("occupancy")
    public int getOccupancy(){
        return userSet.size();
    }

    @Mapping("bet")
    public int getBet(){
        return tor.getContribution();
    }
}