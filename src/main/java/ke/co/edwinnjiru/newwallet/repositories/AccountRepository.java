package ke.co.edwinnjiru.newwallet.repositories;

import ke.co.edwinnjiru.newwallet.models.ledgerSchema.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
