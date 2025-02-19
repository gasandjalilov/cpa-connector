package uz.ucell.cpa.connector.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uz.ucell.cpa.connector.dto.SubscriptionActionDTO;
import uz.ucell.cpa.connector.dto.SubscriptionDTO;
import uz.ucell.cpa.connector.model.UserSubscription;
import uz.ucell.cpa.connector.service.SubscriptionService;

@RestController
@RequestMapping("/v1/cpa")
@RequiredArgsConstructor
public class CampaignController {

    private final SubscriptionService subscriptionService;

    @GetMapping("/subscription/{msisdn}")
    public Flux<UserSubscription> getSubscription(@PathVariable String msisdn) {
        return subscriptionService.getSubscriptions(msisdn);
    }

    @PostMapping("/subscription")
    public Mono<SubscriptionActionDTO> createSubscription(@RequestBody SubscriptionActionDTO subscriptionDTO) {
        return subscriptionService.addSubscription(subscriptionDTO);
    }

    @DeleteMapping("/subscription")
    public Mono<Void> deleteSubscription(@RequestBody SubscriptionActionDTO subscriptionDTO) {
        return subscriptionService.removeSubscription(subscriptionDTO);
    }


}
