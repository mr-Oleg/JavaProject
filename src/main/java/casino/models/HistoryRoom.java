package casino.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "HistoryRoom")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class HistoryRoom implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    @ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
    @JoinColumn(name = "winner")
    private User winner;
    @ManyToMany
    @JoinTable(
            name = "HistoryUserSet",
            joinColumns = {@JoinColumn(name = "room_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private Set<User> userSet = new HashSet<User>();
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "TypeOfRoom")
    private TypeOfRoom typeOfRoom;
    private LocalDate gametime;
    public void addUser(User user) {
        userSet.add(user);
    }

    public void removeUser(User user) {
        userSet.remove(user);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HistoryRoom)) return false;
        HistoryRoom that = (HistoryRoom) o;
        return getId() == that.getId() &&
                getTitle().equals(that.getTitle()) &&
                getWinner().equals(that.getWinner()) &&
                getUserSet().equals(that.getUserSet()) &&
                getTypeOfRoom().equals(that.getTypeOfRoom());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getWinner(), getUserSet(), getTypeOfRoom());
    }
}
