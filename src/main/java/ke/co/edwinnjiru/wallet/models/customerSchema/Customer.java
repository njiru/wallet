package ke.co.edwinnjiru.wallet.models.customerSchema;

import jakarta.persistence.*;
import ke.co.edwinnjiru.wallet.models.BaseEntity;
import ke.co.edwinnjiru.wallet.models.enums.IdentificationType;
import ke.co.edwinnjiru.wallet.models.ledgerSchema.Account;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
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

    @Column(nullable = false)
    private String email;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Phone> phones = new HashSet<>();

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Account> accounts = new HashSet<>();
}
