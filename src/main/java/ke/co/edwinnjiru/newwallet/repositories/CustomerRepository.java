package ke.co.edwinnjiru.newwallet.repositories;

import ke.co.edwinnjiru.newwallet.models.customerSchema.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
