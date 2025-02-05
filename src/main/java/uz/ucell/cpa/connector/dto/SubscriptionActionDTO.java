package uz.ucell.cpa.connector.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.io.Serializable;

@Builder
public record SubscriptionActionDTO (
        String msisdn,
        Integer contentProviderId,
        Integer serviceId,
        String actionId
) implements Serializable {
}
