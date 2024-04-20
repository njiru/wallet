package ke.co.edwinnjiru.newwallet.models.customerSchema;

import jakarta.persistence.*;
import ke.co.edwinnjiru.newwallet.models.BaseEntity;
import ke.co.edwinnjiru.newwallet.models.customerSchema.enums.IdentificationType;
import ke.co.edwinnjiru.newwallet.models.ledgerSchema.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(schema = "customer")
public class Customer extends BaseEntity {
    @Column(nullable = false, length = 20)
    private String firstName;

    @Column(nullable = false, length = 20)
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private IdentificationType identificationType;

    @Column(nullable = false, length = 20)
    private String identificationNumber;

    @Column(nullable = false)
    private LocalDate dateOfBirth;

    @Column(nullable = false, unique = true)
    private String email;

    private LocalDateTime lastModifiedAt;

    private Long lastModifiedBy;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Phone> phones = new HashSet<>();

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Account> accounts = new HashSet<>();
}
