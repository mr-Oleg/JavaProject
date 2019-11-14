package casino;

import casino.services.implementations.*;
import casino.services.interfaces.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public UserService getUserService() {
        return new UserServiceImplementation();
    }
    @Bean
    public BonusPoliciesService getBonusPoliciesService() {
        return new BonusPoliciesServiceImplementation();
    }
    @Bean
    public RoleService getRoleService() {
        return new RoleServiceImplementation();
    }

    @Bean
    public RoomService getRoomService() {
        return new RoomServiceImplementation();
    }
    @Bean
    public TypeOfRoomService getTypeOfRoomService() {
        return new TypeOfRoomServiceImplementation();
    }
}
