package casino.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "BonusPolicies")
@Getter
@Setter
@NoArgsConstructor
@ToString
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class BonusPolicies implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "chance")
    private double chance;
    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "BonusUser",
            joinColumns = {@JoinColumn(name = "bonus_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")}
    )
    private Set<User> bonusUser = new HashSet<User>();

    public void addUser(User user) {
        bonusUser.add(user);
    }

    public void removeUser(User user) {
        bonusUser.remove(user);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BonusPolicies)) return false;
        BonusPolicies that = (BonusPolicies) o;
        return getId() == that.getId() &&
                Double.compare(that.getChance(), getChance()) == 0 &&
                Objects.equals(getBonusUser(), that.getBonusUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getChance(), getBonusUser());
    }
}