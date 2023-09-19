package ke.co.edwinnjiru.wallet.services.impl;

import ke.co.edwinnjiru.wallet.dtos.*;
import ke.co.edwinnjiru.wallet.exceptions.ResourceNotFoundException;
import ke.co.edwinnjiru.wallet.models.customerSchema.Customer;
import ke.co.edwinnjiru.wallet.repositories.CustomerRepository;
import ke.co.edwinnjiru.wallet.services.AccountService;
import ke.co.edwinnjiru.wallet.services.CustomerService;
import ke.co.edwinnjiru.wallet.services.PhoneService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public CustomerRegResponse createCustomer(CustomerRegDto customerRegDto) {

        Customer customer = customerRepository.save(modelMapper.map(customerRegDto.getCustomer(), Customer.class));

        phoneService.createPhone(customer.getActorId(), customerRegDto.getPhone());

        /**
         * Use phone Number as account
         * Figure out generating account number later
         */
        long accountNumber = Long.parseLong("254" + customerRegDto.getPhone().getPhoneNumber().substring(1));
        AccountDto acc = customerRegDto.getAccount();
        acc.setAccountNumber(accountNumber);

        AccountDto accountDto = accountService.createAccount(customer.getActorId(), acc);

        CustomerRegResponse response = new CustomerRegResponse();
        response.setCustomerId(customer.getActorId().toString());
        response.setAccountNumber(accountDto.getAccountNumber().toString());
        response.setMessage("Successfully created");
        return response;
    }

    @Override
    public CustomerResponse getAllCustomers(int pageNo, int pageSize, String sortBy, String sortOrder) {
        Sort sort = sortOrder.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        //Create Pageable instance
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Customer> customers = customerRepository.findAll(pageable);

        return getPagedResponse(customers);
    }

    @Override
    public CustomerDetailsDto getCustomerById(long customerId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new ResourceNotFoundException("customer", "id", customerId));
        List<PhoneDto> phones = phoneService.getPhoneByCustomerId(customerId);
        List<AccountDto> accounts = accountService.getAccountDetailsByCustomerId(customerId);

        CustomerDetailsDto response = new CustomerDetailsDto();
        response.setCustomer(mapToDTO(customer));
        response.setAccount(accounts);
        response.setPhone(phones);
        return response;
    }

    private CustomerDto mapToDTO(Customer customer) {
        return modelMapper.map(customer, CustomerDto.class);
    }

    private CustomerResponse getPagedResponse(Page<Customer> customers) {
        List<Customer> listOfCustomers = customers.getContent();

        List<CustomerDto> content = listOfCustomers.stream().map(this::mapToDTO).toList();

        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setContent(content);
        customerResponse.setPageNo(customers.getNumber());
        customerResponse.setPageSize(customers.getSize());
        customerResponse.setTotalElements(customers.getTotalElements());
        customerResponse.setTotalPages(customers.getTotalPages());
        customerResponse.setLast(customers.isLast());

        return customerResponse;
    }
}
