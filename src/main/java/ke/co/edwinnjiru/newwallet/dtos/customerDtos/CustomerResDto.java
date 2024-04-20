package ke.co.edwinnjiru.newwallet.dtos.customerDtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResDto {
    private CustomerDto customer;
    private String accountNumber;
}
