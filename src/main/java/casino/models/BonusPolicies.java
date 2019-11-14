package casino.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "BonusPolicies")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
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
    @JoinTable(name = "BonusUser" ,joinColumns = @JoinColumn(name = "bonus_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> bonusUser = new HashSet<User>();

    public void addUser(User user){
        bonusUser.add(user);
    }

    public void removeUser(User user){
        bonusUser.remove(user);
    }

}