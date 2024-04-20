package ke.co.edwinnjiru.newwallet.services.impl;

import ke.co.edwinnjiru.newwallet.dtos.accountDtos.AccountDto;
import ke.co.edwinnjiru.newwallet.dtos.customerDtos.CustomerDto;
import ke.co.edwinnjiru.newwallet.dtos.customerDtos.CustomerResDto;
import ke.co.edwinnjiru.newwallet.dtos.customerDtos.PhoneDto;
import ke.co.edwinnjiru.newwallet.models.customerSchema.Customer;
import ke.co.edwinnjiru.newwallet.models.customerSchema.Phone;
import ke.co.edwinnjiru.newwallet.repositories.CustomerRepository;
import ke.co.edwinnjiru.newwallet.services.AccountService;
import ke.co.edwinnjiru.newwallet.services.PhoneService;
import org.modelmapper.ModelMapper;
import org.springframework.transaction.annotation.Transactional;
import ke.co.edwinnjiru.newwallet.dtos.customerDtos.CustRegDto;
import ke.co.edwinnjiru.newwallet.services.CustomerService;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final PhoneService phoneService;
    private  final AccountService accountService;
    private final ModelMapper modelMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, PhoneService phoneService, AccountService accountService, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.phoneService = phoneService;
        this.accountService = accountService;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public CustomerResDto createCustomer(CustRegDto custRegDto) {
        Customer customer = customerRepository.save(modelMapper.map(custRegDto.getCustomer(), Customer.class));
        String phoneNumber = null;
        for (int i = 0; i < custRegDto.getPhone().size(); i++) {
            PhoneDto phoneDto = custRegDto.getPhone().get(i);
            phoneDto.setIsPrimary(i == 0);
            // used to create wallet account
            if(phoneDto.getIsPrimary())  phoneNumber = phoneDto.getPhoneNumber();
            phoneService.createPhone(phoneDto, customer);
        }

        AccountDto accountDto = accountService.createAccount(phoneNumber, customer);

        CustomerResDto customerResDto = new CustomerResDto();
        customerResDto.setCustomer(modelMapper.map(customer, CustomerDto.class));
        customerResDto.setAccountNumber(accountDto.getAccountNumber());
        return customerResDto;
    }
}

