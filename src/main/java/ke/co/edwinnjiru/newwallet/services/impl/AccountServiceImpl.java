package ke.co.edwinnjiru.newwallet.services.impl;

import ke.co.edwinnjiru.newwallet.dtos.accountDtos.AccountDto;
import ke.co.edwinnjiru.newwallet.models.customerSchema.Customer;
import ke.co.edwinnjiru.newwallet.models.customerSchema.Phone;
import ke.co.edwinnjiru.newwallet.models.enums.Status;
import ke.co.edwinnjiru.newwallet.models.ledgerSchema.Account;
import ke.co.edwinnjiru.newwallet.repositories.AccountRepository;
import ke.co.edwinnjiru.newwallet.repositories.PhoneRepository;
import ke.co.edwinnjiru.newwallet.services.AccountService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final ModelMapper modelMapper;

    public AccountServiceImpl(AccountRepository accountRepository, ModelMapper modelMapper) {
        this.accountRepository = accountRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public AccountDto createAccount(String phoneNumber, Customer customer) {
        phoneNumber = "254" + phoneNumber.trim().substring(1);
        Account account = new Account();
        account.setAccountNumber(phoneNumber);
        account.setCustomer(customer);
        account.setAccountStatus(Status.active);
        return modelMapper.map(accountRepository.save(account), AccountDto.class);
    }
}
