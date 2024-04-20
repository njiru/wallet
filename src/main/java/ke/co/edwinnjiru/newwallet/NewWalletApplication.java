package ke.co.edwinnjiru.newwallet;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
        info = @Info(
                title = "Wallet App REST APIs",
                description = "Wallet App REST APIs Documentation",
                version = "v1.0.0",
                contact = @Contact(
                        name = "Edwin",
                        email = "edwinnjiru@gmail.com",
                        url = "https://linked.com/ln/edwinkivuti"
                ),
                license = @License(
                        name = "Apache 2.0"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "Spring Boot Wallet App Documentation",
                url = "https://www.github.com" // github
        )
)
@SpringBootApplication
public class NewWalletApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewWalletApplication.class, args);
    }

}
