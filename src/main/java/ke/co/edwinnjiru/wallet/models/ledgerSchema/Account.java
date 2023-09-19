package ke.co.edwinnjiru.wallet.models.ledgerSchema;

import jakarta.persistence.*;
import ke.co.edwinnjiru.wallet.models.BaseEntity;
import ke.co.edwinnjiru.wallet.models.customerSchema.Customer;
import ke.co.edwinnjiru.wallet.models.enums.Status;
import ke.co.edwinnjiru.wallet.models.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;


@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "ledger")
@EqualsAndHashCode(callSuper = true)
public class Account extends BaseEntity{

    @Column(nullable = false, length = 100)
    private String accountName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20, columnDefinition = "varchar(20) default 'current'")
    private AccountType accountType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20, columnDefinition = "varchar(20) default 'active'")
    private Status accountStatus;

    @Column(nullable = false, unique = true, updatable = false)
    private Long accountNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_actorId", nullable = false)
    private Customer customer;

    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    private Balance balance;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Ledger> ledgers = new HashSet<>();
}
