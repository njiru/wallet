package ke.co.edwinnjiru.newwallet.dtos.customerDtos;

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
    @Size(min = 10, max = 10, message = "Phone number should be at least 10 characters long")
    private String phoneNumber;

    private Boolean isPrimary;

    private String phoneStatus;

    private String phoneType;

}

