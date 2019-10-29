package main.java.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class User {

    private long id;
    private long role_id;
    private String fName;
    private String lName;
    private String login;
    private String password;
    private String email;
    private LocalDate dateOfBirth;
    private LocalDate dateOfSignUp;
    private BigDecimal balance;
    private Set<BonusPolicies> bonusPoliciesSet = new HashSet<BonusPolicies>();
    private Set<Room> roomSet = new HashSet<Room>();

    public User() {

    }

    public User(long id, long role_id, String fName, String lName, String login, String password, String email, LocalDate dateOfBirth, LocalDate dateOfSignUp, BigDecimal balance, Set<BonusPolicies> bonusPoliciesSet, Set<Room> roomSet) {
        this.id = id;
        this.role_id = role_id;
        this.fName = fName;
        this.lName = lName;
        this.login = login;
        this.password = password;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.dateOfSignUp = dateOfSignUp;
        this.balance = balance;
        this.bonusPoliciesSet = bonusPoliciesSet;
        this.roomSet = roomSet;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getRole_id() {
        return role_id;
    }

    public void setRole_id(long role_id) {
        this.role_id = role_id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getDateOfSignUp() {
        return dateOfSignUp;
    }

    public void setDateOfSignUp(LocalDate dateOfSignUp) {
        this.dateOfSignUp = dateOfSignUp;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Set<BonusPolicies> getBonusPoliciesSet() {
        return bonusPoliciesSet;
    }

    public void setBonusPoliciesSet(Set<BonusPolicies> bonusPoliciesSet) {
        this.bonusPoliciesSet = bonusPoliciesSet;
    }

    public Set<Room> getRoomSet() {
        return roomSet;
    }

    public void setRoomSet(Set<Room> roomSet) {
        this.roomSet = roomSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId() == user.getId() &&
                getRole_id() == user.getRole_id() &&
                getfName().equals(user.getfName()) &&
                getlName().equals(user.getlName()) &&
                getLogin().equals(user.getLogin()) &&
                getPassword().equals(user.getPassword()) &&
                getEmail().equals(user.getEmail()) &&
                getDateOfBirth().equals(user.getDateOfBirth()) &&
                getDateOfSignUp().equals(user.getDateOfSignUp()) &&
                getBalance().equals(user.getBalance()) &&
                getBonusPoliciesSet().equals(user.getBonusPoliciesSet()) &&
                getRoomSet().equals(user.getRoomSet());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getRole_id(), getfName(), getlName(), getLogin(), getPassword(), getEmail(), getDateOfBirth(), getDateOfSignUp(), getBalance(), getBonusPoliciesSet(), getRoomSet());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", role_id=" + role_id +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", dateOfSignUp=" + dateOfSignUp +
                ", balance=" + balance +
                ", bonusPoliciesSet=" + bonusPoliciesSet +
                ", roomSet=" + roomSet +
                '}';
    }
}