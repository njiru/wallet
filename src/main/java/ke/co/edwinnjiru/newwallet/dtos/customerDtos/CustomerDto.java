package ke.co.edwinnjiru.newwallet.dtos.customerDtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
    private Long actorId;

    @NotEmpty(message = "First name should not be empty")
    @Size(min = 3, max = 20, message = "First name should be at least 3 characters and less than 20")
    private String firstName;

    @NotEmpty(message = "Last name should not be empty")
    @Size(min = 3, max = 20, message = "Last name should be at least 3 characters and less than 20")
    private String lastName;

    @Email(message = "Should be a valid email")
    @Size(min = 5, max = 20, message = "Invalid email size")
    private String email;

    // TODO // handle validation
    @NotEmpty(message = "Identification type should not be empty")
    private String identificationType;

    @NotEmpty(message = "Identification number should not be empty")
    @Size(min = 5, max = 20, message = "Identification number should be at least 5 characters and less than 20")
    private String identificationNumber;

    @NotNull(message = "Date of birth should not be empty")
    private LocalDate dateOfBirth;
}
