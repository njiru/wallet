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
public class PhoneDto {

    private Long actorId;

    @NotEmpty(message = "Phone Number should not be empty")
    @Size(min = 10, max = 12, message = "Phone number should be at least 10 characters and less than 12")
    private String phoneNumber;

    private Boolean isPrimary;

    private String phoneStatus;

    private String phoneType;

}
