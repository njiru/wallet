package ke.co.edwinnjiru.newwallet.models.ledgerSchema;

import jakarta.persistence.*;
import ke.co.edwinnjiru.newwallet.models.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import java.time.LocalDateTime;

@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "ledger")
@EqualsAndHashCode(callSuper = true)
public class GlAccounts extends BaseEntity {

    @Column(nullable = false, length = 100)
    private String accountName;

    @Generated()
    @Column(columnDefinition = "serial", updatable = false)
    private Long accountNumber;

    @Column(nullable = false, columnDefinition = "decimal(10,2) default '0.00'")
    private Double balance;

    private LocalDateTime lastModifiedAt;
}
