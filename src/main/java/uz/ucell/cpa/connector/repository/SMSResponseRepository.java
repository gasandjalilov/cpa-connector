package uz.ucell.cpa.connector.repository;

import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import uz.ucell.cpa.connector.model.SMSResponse;

import java.util.UUID;

@Repository
public interface SMSResponseRepository extends ReactiveCassandraRepository<SMSResponse, UUID> {

    Mono<SMSResponse> findByCpIdAndActionIdAndState(String cpId, String action, int state);
}
