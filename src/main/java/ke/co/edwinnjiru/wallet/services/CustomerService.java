package ke.co.edwinnjiru.wallet.services;

import ke.co.edwinnjiru.wallet.dtos.CustomerDetailsDto;
import ke.co.edwinnjiru.wallet.dtos.CustomerRegDto;
import ke.co.edwinnjiru.wallet.dtos.CustomerRegResponse;
import ke.co.edwinnjiru.wallet.dtos.CustomerResponse;

public interface CustomerService {
    CustomerRegResponse createCustomer(CustomerRegDto customerRegDto);

    CustomerResponse getAllCustomers(int pageNo, int pageSize, String sortBy, String sortOrder);

    CustomerDetailsDto getCustomerById(long customerId);
}
