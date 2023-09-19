package ke.co.edwinnjiru.wallet.services.impl;

import ke.co.edwinnjiru.wallet.dtos.AccountDto;
import ke.co.edwinnjiru.wallet.dtos.BalanceDto;
import ke.co.edwinnjiru.wallet.exceptions.ResourceNotFoundException;
import ke.co.edwinnjiru.wallet.models.customerSchema.Customer;
import ke.co.edwinnjiru.wallet.models.ledgerSchema.Account;
import ke.co.edwinnjiru.wallet.repositories.AccountRepository;
import ke.co.edwinnjiru.wallet.repositories.CustomerRepository;
import ke.co.edwinnjiru.wallet.services.AccountService;
import ke.co.edwinnjiru.wallet.services.BalanceService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    private final CustomerRepository customerRepository;
    private final BalanceService balanceService;
    private final ModelMapper modelMapper;

    public AccountServiceImpl(AccountRepository accountRepository, CustomerRepository customerRepository, BalanceService balanceService, ModelMapper modelMapper) {
        this.accountRepository = accountRepository;
        this.customerRepository = customerRepository;
        this.balanceService = balanceService;
        this.modelMapper = modelMapper;
    }

    @Override
    public AccountDto createAccount(Long customerId, AccountDto accountDto) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new ResourceNotFoundException("customer", "id", customerId));
        Account account = mapToEntity(accountDto);
        account.setCustomer(customer);
        Account acc = accountRepository.save(account);

        // create default ledger
        balanceService.createBalance(acc.getActorId(), new BalanceDto());

        return mapToDto(acc);
    }

    @Override
    public List<AccountDto> getAccountDetailsByCustomerId(long customerId) {
        List<Account> accounts = accountRepository.findByCustomerActorId(customerId);

        return accounts.stream().map(this::mapToDto).toList();
    }

    private Account mapToEntity(AccountDto accountDto) {
        return modelMapper.map(accountDto, Account.class);
    }

    private AccountDto mapToDto(Account account) {
        return modelMapper.map(account, AccountDto.class);
    }


}
