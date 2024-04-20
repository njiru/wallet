package ke.co.edwinnjiru.newwallet.dtos.accountDtos;

import ke.co.edwinnjiru.newwallet.models.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {
    private Status accountStatus;
    private String accountNumber;
    private Double actualBalance;
    private Double availableBalance;
}
