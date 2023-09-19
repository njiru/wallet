package ke.co.edwinnjiru.wallet.models.ledgerSchema;

import jakarta.persistence.*;
import ke.co.edwinnjiru.wallet.models.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(schema = "ledger")
public class Balance extends BaseEntity {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_actorId", nullable = false, updatable = false)
    private Account account;

    @Column(nullable = false, columnDefinition = "decimal(10,2) default '0.00'")
    private Double balance;
}
