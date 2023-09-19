package ke.co.edwinnjiru.wallet.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {

    private Long actorId;

    @NotEmpty(message = "Account name should not be empty")
    @Size(min = 1, max = 100, message = "Account name should be at least 1 character and less than 100")
    private String accountName;

    @NotEmpty(message = "Account type should not be empty")
    @Size(min = 7, max = 10, message = "Account type should be at least 7 characters and less than 10")
    private String accountType;

    private String accountStatus;

    private Long accountNumber;
}
