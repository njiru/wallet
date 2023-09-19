package ke.co.edwinnjiru.wallet.repositories;

import ke.co.edwinnjiru.wallet.models.customerSchema.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
