package uz.ucell.cpa.connector.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uz.ucell.cpa.connector.dto.SubscriptionActionDTO;
import uz.ucell.cpa.connector.dto.SubscriptionDTO;
import uz.ucell.cpa.connector.model.ContentProvider;
import uz.ucell.cpa.connector.model.UserSubscription;
import uz.ucell.cpa.connector.repository.ContentProviderRepository;
import uz.ucell.cpa.connector.repository.UserSubscriptionRepository;
import uz.ucell.cpa.connector.service.SubscriptionService;

@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {

    private final UserSubscriptionRepository userSubscriptionRepository;
    private final ContentProviderRepository contentProviderRepository;
    private final JmsTemplate jmsTemplate;


    @Override
    public Flux<UserSubscription> getSubscriptions(String msisdn) {
        return userSubscriptionRepository.findAllByMsisdn(msisdn);
    }

    @Override
    public Mono<SubscriptionActionDTO> addSubscription(SubscriptionActionDTO actionDTO) {
        return Mono.fromRunnable(() -> jmsTemplate.convertAndSend("smpp", actionDTO))
                .then(Mono.just(actionDTO));
    }

    @Override
    public Mono<Void> removeSubscription(SubscriptionActionDTO actionDTO) {
        return null;
    }

    @Override
    public Flux<ContentProvider> getProviders() {
        return contentProviderRepository.findAll();
    }

    @Override
    public Mono<ContentProvider> addProvider(ContentProvider contentProvider) {
        return contentProviderRepository.save(contentProvider);
    }

    @Override
    public Mono<Void> removeProvider(ContentProvider contentProvider) {
        return contentProviderRepository.deleteByShortNumberAndActionId(contentProvider.getShortNumber(), contentProvider.getActionId());
    }


}
