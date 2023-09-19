package ke.co.edwinnjiru.wallet.repositories;

import ke.co.edwinnjiru.wallet.models.ledgerSchema.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findByCustomerActorId(long customerId);

}
