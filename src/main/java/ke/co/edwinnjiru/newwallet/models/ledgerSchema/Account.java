package ke.co.edwinnjiru.newwallet.models.ledgerSchema;

import jakarta.persistence.*;
import ke.co.edwinnjiru.newwallet.models.BaseEntity;
import ke.co.edwinnjiru.newwallet.models.customerSchema.Customer;
import ke.co.edwinnjiru.newwallet.models.enums.Status;
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
@Table(schema = "ledger")
@EqualsAndHashCode(callSuper = true)
public class Account extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20, insertable = false, columnDefinition = "varchar(20) default 'active'")
    private Status accountStatus;

    @Column(nullable = false, unique = true, updatable = false, length = 20)
    private String accountNumber;

    @Column(nullable = false, insertable = false, columnDefinition = "decimal(10,2) default '0.00'")
    private Double actualBalance;

    @Column(nullable = false, insertable = false, columnDefinition = "decimal(10,2) default '0.00'")
    private Double availableBalance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_actorId", nullable = false)
    private Customer customer;
}
