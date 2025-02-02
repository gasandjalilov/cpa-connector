package uz.ucell.cpa.connector.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uz.ucell.cpa.connector.dto.SubscriptionActionDTO;
import uz.ucell.cpa.connector.dto.SubscriptionDTO;
import uz.ucell.cpa.connector.model.UserSubscription;
import uz.ucell.cpa.connector.repository.UserSubscriptionRepository;
import uz.ucell.cpa.connector.service.SubscriptionService;

@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {

    private final UserSubscriptionRepository userSubscriptionRepository;

    @Override
    public Flux<UserSubscription> getSubscriptions(String msisdn) {
        return userSubscriptionRepository.findAllByMsisdn(msisdn);
    }

    @Override
    public Mono<SubscriptionDTO> addSubscription(SubscriptionActionDTO actionDTO) {
        return null;
    }

    @Override
    public Mono<Void> removeSubscription(SubscriptionActionDTO actionDTO) {
        return null;
    }

    @Override
    public Mono<SubscriptionDTO> updateSubscription(SubscriptionDTO actionDTO) {
        return null;
    }
}
