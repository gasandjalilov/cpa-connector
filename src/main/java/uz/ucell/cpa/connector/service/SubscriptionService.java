package uz.ucell.cpa.connector.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uz.ucell.cpa.connector.dto.SubscriptionActionDTO;
import uz.ucell.cpa.connector.dto.SubscriptionDTO;

public interface SubscriptionService {

    Flux<SubscriptionDTO> getSubscriptions(String msisdn);
    Mono<SubscriptionDTO> addSubscription(SubscriptionActionDTO actionDTO);
    Mono<Void> removeSubscription(SubscriptionActionDTO actionDTO);
    Mono<SubscriptionDTO> updateSubscription(SubscriptionDTO actionDTO);
}
