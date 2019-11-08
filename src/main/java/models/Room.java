package models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Room")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Room implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private double budget;
    private int userAmount;
    @ManyToMany
    @JoinTable(name = "UserSet" ,joinColumns = @JoinColumn(name = "room_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> userSet = new HashSet<User>();
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TypeOfRoom")
    private TypeOfRoom tor;
    public void addUser(User user){
        userSet.add(user);
    }

    public void removeUser(User user){
        userSet.remove(user);
    }
}