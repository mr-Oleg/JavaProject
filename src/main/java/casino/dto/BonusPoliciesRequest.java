package casino.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class BonusPoliciesRequest {

    private int id;
    private double chance;
}
