package uz.ucell.cpa.connector.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PartialChargeInitRequest implements Serializable { // listen
    String msisdn;

    Integer serviceId;
}
