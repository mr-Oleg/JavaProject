package casino.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserResponse {
    private int id;
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private String email;
    private double balance;
}
