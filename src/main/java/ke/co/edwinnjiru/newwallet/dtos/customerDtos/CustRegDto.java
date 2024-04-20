package ke.co.edwinnjiru.newwallet.dtos.customerDtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CustRegDto {

    @Valid
    @NotNull(message = "Customer Details are required.")
    private CustomerDto customer;

    @Valid
    @NotNull(message = "Phone Details are required.")
    private List<PhoneDto> phone;
}
