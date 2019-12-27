package casino.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class BonusPolicyResponse {
    private int id;
    private String login;
    private double chance;
    private int userId;
}
