package main.java.models;

import java.util.Objects;

class Role {

    private long id;
    private String name;
    private String duties;

    public Role() {

    }

    public Role(long id, String name, String duties) {
        this.id = id;
        this.name = name;
        this.duties = duties;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuties() {
        return duties;
    }

    public void setDuties(String duties) {
        this.duties = duties;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;
        Role role = (Role) o;
        return getId() == role.getId() &&
                getName().equals(role.getName()) &&
                getDuties().equals(role.getDuties());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDuties());
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", duties='" + duties + '\'' +
                '}';
    }
}