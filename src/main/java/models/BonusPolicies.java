package main.java.models;

import main.java.models.User;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class BonusPolicies {

    private long id;
    private double chance;
    private HashSet<User> userSet = new HashSet<User>();

    public BonusPolicies() {

    }

    public BonusPolicies(long id, double chance, HashSet<main.java.models.User> userSet) {
        this.id = id;
        this.chance = chance;
        this.userSet = userSet;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getChance() {
        return chance;
    }

    public void setChance(double chance) {
        this.chance = chance;
    }

    public HashSet<main.java.models.User> getUserSet() {
        return userSet;
    }

    public void setUserSet(HashSet<main.java.models.User> userSet) {
        this.userSet = userSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BonusPolicies)) return false;
        BonusPolicies that = (BonusPolicies) o;
        return getId() == that.getId() &&
                Double.compare(that.getChance(), getChance()) == 0 &&
                getUserSet().equals(that.getUserSet());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getChance(), getUserSet());
    }

    @Override
    public String toString() {
        return "BonusPolicies{" +
                "id=" + id +
                ", chance=" + chance +
                ", userSet=" + userSet +
                '}';
    }
}