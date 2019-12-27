package casino.mappers;

import casino.models.User;
import casino.response.UserResponse;
import org.dozer.loader.api.BeanMappingBuilder;
import org.springframework.stereotype.Component;

@Component("UserToUserResponse")
public class UserToUserResponse extends BeanMappingBuilder {

    @Override
    protected void configure() {
        mapping(UserResponse.class, User.class)
                .fields("id", "id")
                .fields("firstName","firstName")
                .fields("lastName","lastName")
                .fields("login","login")
                .fields("password","password")
                .fields("email","email")
                .fields("balance","balance");
    }
}
