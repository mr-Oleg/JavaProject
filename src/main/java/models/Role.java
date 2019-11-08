package models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Role")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "duties")
    private String duties;

    @OneToMany(mappedBy = "role", orphanRemoval = true)
    private List<User> list = new ArrayList<>();

    public Role(String name, String duties) {
        this.name = name;
        this.duties = duties;
    }
}