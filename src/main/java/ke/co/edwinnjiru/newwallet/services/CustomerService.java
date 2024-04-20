package ke.co.edwinnjiru.newwallet.services;

import ke.co.edwinnjiru.newwallet.dtos.customerDtos.CustRegDto;
import ke.co.edwinnjiru.newwallet.dtos.customerDtos.CustomerResDto;

public interface CustomerService {
    CustomerResDto createCustomer(CustRegDto custRegDto);
}
