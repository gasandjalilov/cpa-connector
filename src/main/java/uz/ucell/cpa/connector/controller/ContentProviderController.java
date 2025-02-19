package uz.ucell.cpa.connector.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uz.ucell.cpa.connector.dto.SubscriptionActionDTO;
import uz.ucell.cpa.connector.model.ContentProvider;
import uz.ucell.cpa.connector.model.UserSubscription;
import uz.ucell.cpa.connector.service.SubscriptionService;

@RestController
@RequestMapping("/v1/cpa/campaign")
@RequiredArgsConstructor
public class ContentProviderController {
    private final SubscriptionService service;

    @GetMapping()
    public Flux<ContentProvider> getProviders() {
        return service.getProviders();
    }

    @PostMapping()
    public Mono<ContentProvider> createProvider(@RequestBody ContentProvider contentProvider) {
        return service.addProvider(contentProvider);
    }

    @DeleteMapping()
    public Mono<Void> deleteProvider(@RequestBody ContentProvider contentProvider) {
        return service.removeProvider(contentProvider);
    }
}
