package casino;

import casino.dto.BonusPoliciesRequest;
import casino.models.BonusPolicies;
import casino.services.implementations.*;
import casino.services.interfaces.*;
import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
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
    public HistoryRoomService getHistoryRoomService() {
        return new HistoryRoomServiceImplementation();
    }

    @Bean
    public TypeOfRoomService getTypeOfRoomService() {
        return new TypeOfRoomServiceImplementation();
    }

    @Bean
    public DozerBeanMapper mapper() throws Exception {
        DozerBeanMapper mapper = new DozerBeanMapper();
        mapper.addMapping(objectMappingBuilder);
        return mapper;
    }

    BeanMappingBuilder objectMappingBuilder = new BeanMappingBuilder() {
        @Override
        protected void configure() {
            mapping(BonusPoliciesRequest.class, BonusPolicies.class)
                    .fields("id", "id").fields("chance", "chance");
        }
    };
}
