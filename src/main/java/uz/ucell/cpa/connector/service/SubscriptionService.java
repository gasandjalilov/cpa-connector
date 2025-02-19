package uz.ucell.cpa.connector.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uz.ucell.cpa.connector.dto.SubscriptionActionDTO;
import uz.ucell.cpa.connector.dto.SubscriptionDTO;
import uz.ucell.cpa.connector.model.ContentProvider;
import uz.ucell.cpa.connector.model.UserSubscription;

public interface SubscriptionService {

    Flux<UserSubscription> getSubscriptions(String msisdn);
    Mono<SubscriptionActionDTO> addSubscription(SubscriptionActionDTO actionDTO);
    Mono<Void> removeSubscription(SubscriptionActionDTO actionDTO);
    Flux<ContentProvider> getProviders();
    Mono<ContentProvider> addProvider(ContentProvider contentProvider);
    Mono<Void> removeProvider(ContentProvider contentProvider);
}
