package casino.dto;

import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserDTO {

    private int id;
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private String email;
    private LocalDate dateOfBirth;
    private LocalDate dateOfSignUp;
    private double balance;

}
