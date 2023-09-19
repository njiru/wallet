package ke.co.edwinnjiru.wallet.models.ledgerSchema;

import jakarta.persistence.*;
import ke.co.edwinnjiru.wallet.models.customerSchema.Customer;
import ke.co.edwinnjiru.wallet.models.enums.DrCr;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "ledger")
public class Ledger {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ledgerId_generator")
    @SequenceGenerator(name = "ledgerId_generator", initialValue = 1, allocationSize = 1)
    private Long ledgerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_accountNumber", nullable = false)
    private Account account;

    @Column(nullable = false, columnDefinition = "decimal(10,2) default '0.00'")
    private Double amount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private DrCr DrCr;

    @Column(nullable = false, columnDefinition = "decimal(10,2) default '0.00'")
    private Double runningBalance;

    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    private LocalDateTime createdAt;
}
