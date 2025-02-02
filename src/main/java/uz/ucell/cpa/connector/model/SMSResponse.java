package uz.ucell.cpa.connector.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("sms_messages")
public class SMSResponse implements Serializable {

    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED,name = "content_provider_id", ordinal = 0)
    private String cpId;
    @PrimaryKeyColumn(type = PrimaryKeyType.CLUSTERED,name = "action_id",ordinal = 1)
    private String actionId;

    @PrimaryKeyColumn(type = PrimaryKeyType.CLUSTERED,name = "state",ordinal = 2)
    private Integer state;
    private String response;
}
