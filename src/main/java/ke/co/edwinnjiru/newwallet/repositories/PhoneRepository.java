package ke.co.edwinnjiru.newwallet.repositories;

import ke.co.edwinnjiru.newwallet.models.customerSchema.Customer;
import ke.co.edwinnjiru.newwallet.models.customerSchema.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
    Optional<Phone> findByCustomerAndIsPrimary(Customer customer, Boolean isPrimary);
}
