package ke.co.edwinnjiru.wallet.services;

import ke.co.edwinnjiru.wallet.dtos.AccountDto;

import java.util.List;

public interface AccountService {
    AccountDto createAccount(Long customerId, AccountDto accountDto);

    List<AccountDto> getAccountDetailsByCustomerId(long customerId);
}
