package casino.mappers;

import casino.models.BonusPolicies;
import casino.response.BonusPolicyResponse;
import org.dozer.loader.api.BeanMappingBuilder;
import org.springframework.stereotype.Component;

@Component("BonusPolicyToBonusPolicyResponse")
public class BonusPolicyToBonusPolicyResponse extends BeanMappingBuilder {
    @Override
    protected void configure() {
        mapping(BonusPolicyResponse.class, BonusPolicies.class)
                .fields("chance", "chance")
                .fields("id", "id");
    }
}
