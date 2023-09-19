package ke.co.edwinnjiru.wallet.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerRegDto {

    @Valid
    @NotNull(message = "Customer Details are required.")
    private CustomerDto customer;

    @Valid
    @NotNull(message = "Phone Details are required.")
    private PhoneDto phone;

    @Valid
    @NotNull(message = "Account Details are required.")
    private AccountDto account;
}
