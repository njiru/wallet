package ke.co.edwinnjiru.newwallet.models.customerSchema;

import jakarta.persistence.*;
import ke.co.edwinnjiru.newwallet.models.BaseEntity;
import ke.co.edwinnjiru.newwallet.models.customerSchema.enums.PhoneType;
import ke.co.edwinnjiru.newwallet.models.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(schema = "customer")
public class Phone extends BaseEntity {

    @Column(nullable = false, length = 20, unique = true, updatable = false)
    private String phoneNumber;

    @Column(columnDefinition = "boolean default false")
    private Boolean isPrimary;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20, columnDefinition = "varchar(20) default 'active'")
    private Status phoneStatus;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20, columnDefinition = "varchar(20) default 'home'")
    private PhoneType phoneType;

    private LocalDateTime lastModifiedAt;

    private Long lastModifiedBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_actorId", nullable = false)
    private Customer customer;
}
