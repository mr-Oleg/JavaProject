package casino.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "Role")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Role implements Serializable, GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "duties")
    private String duties;
    @JsonIgnore
    @OneToMany(mappedBy = "role", orphanRemoval = true)
    private List<User> list = new ArrayList<>();

    public Role(String name, String duties) {
        this.name = name;
        this.duties = duties;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", duties='" + duties + '\'' +
                //", list=" + Arrays.toString(list.toArray()) +
                '}';
    }

    @Override
    public String getAuthority() {
        return getName();
    }
}