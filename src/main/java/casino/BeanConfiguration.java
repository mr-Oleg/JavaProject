package casino;

import casino.services.implementations.*;
import casino.services.interfaces.*;
import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

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
    public DozerBeanMapper mapperRoom( @Autowired @Qualifier("RoomToRoomResponse") BeanMappingBuilder objectMappingBuilder) throws Exception {
        DozerBeanMapper mapper = new DozerBeanMapper();
        mapper.addMapping(objectMappingBuilder);
        return mapper;
    }

    @Bean
    public DozerBeanMapper mapperBonusPolicy( @Autowired @Qualifier("BonusPolicyToBonusPolicyResponse") BeanMappingBuilder objectMappingBuilder) throws Exception {
        DozerBeanMapper mapper = new DozerBeanMapper();
        mapper.addMapping(objectMappingBuilder);
        return mapper;
    }

    @Bean
    public DozerBeanMapper mapperHistoryRoom( @Autowired @Qualifier("HistoryRoomToHistoryRoomResponse") BeanMappingBuilder objectMappingBuilder) throws Exception {
        DozerBeanMapper mapper = new DozerBeanMapper();
        mapper.addMapping(objectMappingBuilder);
        return mapper;
    }

    @Bean
    public DozerBeanMapper mapperUser( @Autowired @Qualifier("UserToUserResponse") BeanMappingBuilder objectMappingBuilder) throws Exception {
        DozerBeanMapper mapper = new DozerBeanMapper();
        mapper.addMapping(objectMappingBuilder);
        return mapper;
    }
}
