package ke.co.edwinnjiru.newwallet.services;

import ke.co.edwinnjiru.newwallet.dtos.accountDtos.AccountDto;
import ke.co.edwinnjiru.newwallet.models.customerSchema.Customer;

public interface AccountService {

    AccountDto createAccount(String phoneNumber, Customer customer);

}
