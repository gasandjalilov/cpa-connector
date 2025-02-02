package uz.ucell.cpa.connector.repository;

import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import uz.ucell.cpa.connector.model.UserMessage;

import java.util.UUID;

@Repository
public interface UserMessagesRepository extends ReactiveCassandraRepository<UserMessage, UUID> {

    Mono<UserMessage> findByRequestId(UUID id);
}
