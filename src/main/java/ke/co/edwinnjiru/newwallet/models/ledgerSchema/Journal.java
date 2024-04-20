package ke.co.edwinnjiru.newwallet.models.ledgerSchema;

import jakarta.persistence.*;
import ke.co.edwinnjiru.newwallet.models.BaseEntity;
import ke.co.edwinnjiru.newwallet.models.enums.Channel;

import ke.co.edwinnjiru.newwallet.models.enums.Status;
import ke.co.edwinnjiru.newwallet.models.ledgerSchema.enums.Currency;
import ke.co.edwinnjiru.newwallet.models.ledgerSchema.enums.DrCr;
import ke.co.edwinnjiru.newwallet.models.ledgerSchema.enums.IsCustomerGL;
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
@AttributeOverride(name = "createdAt", column = @Column(name = "transactionDate"))
public class Journal extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20, columnDefinition = "varchar(20) default 'ussd'")
    private Channel channel;

    @Column(nullable = false, length = 100)
    private String refNo;

    @Column(nullable = false, updatable = false)
    private Long accountNumber;

    @Column(nullable = false, columnDefinition = "decimal(10,2) default '0.00'")
    private Double amount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20, columnDefinition = "varchar(10) default 'KES'")
    private Currency currency;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private DrCr drCr;

    @Column(nullable = false, length = 200)
    private String narration;

    @Column(nullable = false, columnDefinition = "decimal(10,2) default '0.00'")
    private Double runningBalance;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20, columnDefinition = "varchar(10) default 'KES'")
    private IsCustomerGL isCustomerGL;
}
