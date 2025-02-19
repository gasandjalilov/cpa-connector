package uz.ucell.cpa.connector.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.io.Serializable;

@Builder
public record SubscriptionActionDTO (
        String msisdn,
        String contentProviderId,
        String action
) implements Serializable {
}
