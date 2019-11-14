package casino.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "User")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private String email;
    private LocalDate dateOfBirth;
    private LocalDate dateOfSignUp;
    private double balance;
    @ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
    @JoinColumn(name = "role")
    private Role role;
    @ManyToMany(mappedBy = "bonusUser",cascade = {CascadeType.ALL})
    private Set<BonusPolicies> bonusPoliciesSet = new HashSet<BonusPolicies>();
    @JsonIgnore
    @ManyToMany(mappedBy = "userSet",cascade = {CascadeType.ALL})
    private Set<Room> roomSet = new HashSet<Room>();

    public User(String firstName, String lastName, String login, String password, String email, LocalDate dateOfBirth, LocalDate dateOfSignUp, double balance, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.dateOfSignUp = dateOfSignUp;
        this.balance = balance;
        this.role = role;
    }

    public void addRoom(Room r){
        roomSet.add(r);
    }
}