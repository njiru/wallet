package ke.co.edwinnjiru.wallet.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountDetailsDto {
    private AccountDto account;
    private Double balance;
}
