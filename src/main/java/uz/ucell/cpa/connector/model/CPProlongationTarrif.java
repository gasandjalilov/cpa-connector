package uz.ucell.cpa.connector.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("cp_prolong_tarrif")
public class CPProlongationTarrif implements Serializable {

    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED,name = "content_id",ordinal = 0)
    private UUID id;

    @Column("amount")
    private Long amount;

    @Column("service_id")
    private Long serviceId;
}
