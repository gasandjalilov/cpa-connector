package uz.ucell.cpa.connector.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Table("user_subscription")
public class UserSubscription implements Serializable {
    @CassandraType(type = CassandraType.Name.SET, typeArguments = CassandraType.Name.UUID)
    private SortedSet<UUID> requestIds = new TreeSet<>(UserSubscription::compareTo);

    public UserSubscription(UUID requestId, String msisdn, String cpId, Long serviceId, String actionId, Integer state, Long langId) {
        this.requestIds.add(requestId);
        this.msisdn = msisdn;
        this.cpId = cpId;
        this.serviceId = serviceId;
        this.actionId = actionId;
        this.state = state;
        this.langId = langId;
    }

    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED,name = "msisdn",ordinal = 0)
    private String msisdn;

    @PrimaryKeyColumn(type = PrimaryKeyType.CLUSTERED,name = "content_provider_id",ordinal = 2)
    private String cpId;

    private Long serviceId;

    private String actionId;

    private Integer state;

    private Integer typeId;

    @Column("createddate")
    @PrimaryKeyColumn(type = PrimaryKeyType.CLUSTERED, ordinal = 3)
    private LocalDateTime createdDate;

    @Column("langid")
    private Long langId;

    static int compareTo(UUID a, UUID b){
        return Long.compare(b.timestamp(),a.timestamp());
    }


    public void addRequestId(UUID generate) {
        this.requestIds.add(generate);
    }
}
