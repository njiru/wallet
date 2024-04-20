package ke.co.edwinnjiru.newwallet.controllers;

import jakarta.validation.Valid;
import ke.co.edwinnjiru.newwallet.dtos.customerDtos.CustRegDto;
import ke.co.edwinnjiru.newwallet.dtos.customerDtos.CustomerResDto;
import ke.co.edwinnjiru.newwallet.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<CustomerResDto> addCustomer(@Valid @RequestBody CustRegDto custRegDto) {
        return new ResponseEntity<>(customerService.createCustomer(custRegDto), HttpStatus.CREATED);
    }
}
