package models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
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
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fName;
    private String lName;
    private String login;
    private String password;
    private String email;
    private LocalDate dateOfBirth;
    private LocalDate dateOfSignUp;
    private double balance;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role")
    private Role role;
    @ManyToMany(mappedBy = "bonusUser")
    private Set<BonusPolicies> bonusPoliciesSet = new HashSet<BonusPolicies>();
    @ManyToMany(mappedBy = "userSet")
    private Set<Room> roomSet = new HashSet<Room>();

    public User(String fName, String lName, String login, String password, String email, LocalDate dateOfBirth, LocalDate dateOfSignUp, double balance, Role role) {
        this.fName = fName;
        this.lName = lName;
        this.login = login;
        this.password = password;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.dateOfSignUp = dateOfSignUp;
        this.balance = balance;
        this.role = role;
    }
}