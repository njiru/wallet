package ke.co.edwinnjiru.wallet.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CustomerDetailsDto {
    private CustomerDto customer;
    private List<PhoneDto> phone;
    private List<AccountDto> account;
}
