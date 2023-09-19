package ke.co.edwinnjiru.wallet.controllers;

import jakarta.validation.Valid;
import ke.co.edwinnjiru.wallet.dtos.CustomerDetailsDto;
import ke.co.edwinnjiru.wallet.dtos.CustomerRegDto;
import ke.co.edwinnjiru.wallet.dtos.CustomerRegResponse;
import ke.co.edwinnjiru.wallet.dtos.CustomerResponse;
import ke.co.edwinnjiru.wallet.services.CustomerService;
import ke.co.edwinnjiru.wallet.utils.AppConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<CustomerRegResponse> createCustomer(@Valid  @RequestBody CustomerRegDto customerRegDto) {
        return new ResponseEntity<>(customerService.createCustomer(customerRegDto), HttpStatus.CREATED);
    }

    @GetMapping
    public CustomerResponse getAllCustomers(
            @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortOrder", defaultValue = AppConstants.DEFAULT_SORT_ORDER, required = false) String sortOrder
    ) {
        return customerService.getAllCustomers(pageNo, pageSize, sortBy, sortOrder);
    }

    @GetMapping("/{id}")
    public CustomerDetailsDto getCustomerById(@PathVariable(name = "id") long customerId) {
        return customerService.getCustomerById(customerId);
    }
}
