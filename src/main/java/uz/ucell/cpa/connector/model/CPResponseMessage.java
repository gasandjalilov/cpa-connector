package uz.ucell.cpa.connector.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CPResponseMessage implements Serializable {
    private String msisdn;

    private String text;

    private String alphaName;
}
