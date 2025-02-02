package uz.ucell.cpa.connector.repository;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uz.ucell.cpa.connector.model.UserSubscription;

@Repository
public interface UserSubscriptionRepository extends ReactiveCassandraRepository<UserSubscription,String> {

    @Query("select * from user_subscription where msisdn=:msisdn and content_provider_id=:cp_id order by createddate desc limit 1")
    Mono<UserSubscription> findByMsisdnAndCpId(@Param("msisdn") String msisdn, @Param("cp_id") String cpId);
    @Query("select * from user_subscription where msisdn=:msisdn and serviceid=:service_id ALLOW FILTERING")
    Mono<UserSubscription> findByMsisdnAndServiceId(@Param("msisdn") String msisdn, @Param("service_id") Long serviceId);
    Flux<UserSubscription> findAllByMsisdn(String msisdn);
}
