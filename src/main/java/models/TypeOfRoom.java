package models;

import javax.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TypeOfRoom")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class TypeOfRoom implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "contribution")
    private int contribution;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "tor", orphanRemoval = true)
    private List<Room> rooms = new ArrayList<>();

}
