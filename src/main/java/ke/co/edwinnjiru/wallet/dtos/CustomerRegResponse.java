package ke.co.edwinnjiru.wallet.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerRegResponse {
    private String customerId;
    private String accountNumber;
    private String message;
}
