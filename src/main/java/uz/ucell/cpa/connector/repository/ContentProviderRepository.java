package uz.ucell.cpa.connector.repository;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uz.ucell.cpa.connector.model.ContentProvider;

@Repository
public interface ContentProviderRepository extends ReactiveCassandraRepository<ContentProvider,String> {


    Mono<ContentProvider> findByShortNumberAndActionId(String cpId, String actionId);

    @AllowFiltering
    Flux<ContentProvider> findByServiceId(Long serviceId);
    @AllowFiltering
    Mono<ContentProvider> findByShortNumberAndActionIdAndTypeId(String cpId, String actionId, Integer typeId);
}
