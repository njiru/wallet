package ke.co.edwinnjiru.wallet.repositories;

import ke.co.edwinnjiru.wallet.models.ledgerSchema.Balance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BalanceRepository extends JpaRepository<Balance, Long> {

    Optional<Balance> findByAccountActorId(long accountId);
}
