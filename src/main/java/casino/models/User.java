package casino.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;

@Entity
@Table(name = "User")
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User implements Serializable, UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String login;
    private String password;
//    @Transient
//    private String passwordConfirm;
    private String email;
    private LocalDate dateOfBirth;
    private LocalDate dateOfSignUp;
    private double balance;
    @ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
    @JoinColumn(name = "role")
    private Role role;
    @JsonIgnore
    @OneToMany(mappedBy = "winner", orphanRemoval = true)
    private List<HistoryRoom> historyRooms1 = new ArrayList<>();
    @ManyToMany(
            mappedBy = "bonusUser",
            cascade = {CascadeType.ALL})
    private Set<BonusPolicies> bonusPoliciesSet = new HashSet<BonusPolicies>();
    @JsonIgnore
    @ManyToMany(
            mappedBy = "userSet",
            cascade = {CascadeType.ALL})
    private Set<Room> roomSet = new HashSet<Room>();
    @JsonIgnore
    @ManyToMany(
            mappedBy = "historyUserSet",
            cascade = {CascadeType.ALL})
    private Set<HistoryRoom> historyRooms = new HashSet<HistoryRoom>();
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

    public void removeRoom(Room r){
        roomSet.remove(r);
    }

    public void addHistoryRoom(HistoryRoom r){
        historyRooms.add(r);
    }

    public void removeHistoryRoom(HistoryRoom r){
        historyRooms.remove(r);
    }

    public void addBonusPolicy(BonusPolicies bp){
        bonusPoliciesSet.add(bp);
    }

    public void removeBonusPolicy(BonusPolicies bp){
        bonusPoliciesSet.remove(bp);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId() == user.getId() &&
                getFirstName().equals(user.getFirstName()) &&
                getLastName().equals(user.getLastName()) &&
                getLogin().equals(user.getLogin()) &&
                getPassword().equals(user.getPassword()) &&
                getEmail().equals(user.getEmail()) &&
                getRole().equals(user.getRole());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getLogin(), getPassword(), getEmail(), getRole());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", dateOfSignUp=" + dateOfSignUp +
                ", balance=" + balance +
                '}';
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Role> set = new HashSet<>();
        set.add(role);
        return set;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}