package main.java.models;

import java.util.Objects;

class TypeOfRoom {
    private long id;
    private int contribution;
    private String description;

    public TypeOfRoom() {

    }

    public TypeOfRoom(long id, int contribution, String description) {
        this.id = id;
        this.contribution = contribution;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getContribution() {
        return contribution;
    }

    public void setContribution(int contribution) {
        this.contribution = contribution;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TypeOfRoom)) return false;
        TypeOfRoom that = (TypeOfRoom) o;
        return getId() == that.getId() &&
                getContribution() == that.getContribution() &&
                getDescription().equals(that.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getContribution(), getDescription());
    }

    @Override
    public String toString() {
        return "TypeOfRoom{" +
                "id=" + id +
                ", contribution=" + contribution +
                ", description='" + description + '\'' +
                '}';
    }
}
