package ke.co.edwinnjiru.wallet.repositories;

import ke.co.edwinnjiru.wallet.models.customerSchema.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
    List<Phone> findByCustomerActorId(long customerId);
}
