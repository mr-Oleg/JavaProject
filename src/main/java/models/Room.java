package main.java.models;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Room {
    private long id;
    private long typeOfRoom_id;
    private String title;
    private BigDecimal budget;
    private int userAmount;
    private Set<User> userSet = new HashSet<User>();

    public Room() {

    }

    public Room(long id, long typeOfRoom_id, String title, BigDecimal budget, int userAmount, Set<User> userSet) {
        this.id = id;
        this.typeOfRoom_id = typeOfRoom_id;
        this.title = title;
        this.budget = budget;
        this.userAmount = userAmount;
        this.userSet = userSet;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTypeOfRoom_id() {
        return typeOfRoom_id;
    }

    public void setTypeOfRoom_id(long typeOfRoom_id) {
        this.typeOfRoom_id = typeOfRoom_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    public int getUserAmount() {
        return userAmount;
    }

    public void setUserAmount(int userAmount) {
        this.userAmount = userAmount;
    }

    public Set<User> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room)) return false;
        Room room = (Room) o;
        return getId() == room.getId() &&
                getTypeOfRoom_id() == room.getTypeOfRoom_id() &&
                getUserAmount() == room.getUserAmount() &&
                getTitle().equals(room.getTitle()) &&
                getBudget().equals(room.getBudget()) &&
                getUserSet().equals(room.getUserSet());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTypeOfRoom_id(), getTitle(), getBudget(), getUserAmount(), getUserSet());
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", typeOfRoom_id=" + typeOfRoom_id +
                ", title='" + title + '\'' +
                ", budget=" + budget +
                ", userAmount=" + userAmount +
                ", userSet=" + userSet +
                '}';
    }
}