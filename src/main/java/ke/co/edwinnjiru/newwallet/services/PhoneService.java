package ke.co.edwinnjiru.newwallet.services;

import ke.co.edwinnjiru.newwallet.dtos.customerDtos.PhoneDto;
import ke.co.edwinnjiru.newwallet.models.customerSchema.Customer;

public interface PhoneService {
    void createPhone(PhoneDto phoneDto, Customer customer);
}
