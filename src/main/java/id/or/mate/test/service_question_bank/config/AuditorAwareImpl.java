package id.or.mate.test.service_question_bank.config;

import org.bson.types.ObjectId;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<ObjectId> {
    @Override
    public Optional<ObjectId> getCurrentAuditor() {
        // TODO: get user from the security context
        return Optional.of(new ObjectId());
    }

}
