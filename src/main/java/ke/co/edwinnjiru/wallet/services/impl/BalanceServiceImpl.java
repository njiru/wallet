package ke.co.edwinnjiru.wallet.services.impl;

import ke.co.edwinnjiru.wallet.dtos.BalanceDto;
import ke.co.edwinnjiru.wallet.exceptions.ResourceNotFoundException;
import ke.co.edwinnjiru.wallet.models.ledgerSchema.Account;
import ke.co.edwinnjiru.wallet.models.ledgerSchema.Balance;
import ke.co.edwinnjiru.wallet.repositories.AccountRepository;
import ke.co.edwinnjiru.wallet.repositories.BalanceRepository;
import ke.co.edwinnjiru.wallet.services.BalanceService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class BalanceServiceImpl implements BalanceService {
    private final BalanceRepository balanceRepository;

    private final AccountRepository accountRepository;
    private final ModelMapper modelMapper;

    public BalanceServiceImpl(BalanceRepository balanceRepository, ModelMapper modelMapper, AccountRepository accountRepository) {
        this.balanceRepository = balanceRepository;
        this.modelMapper = modelMapper;
        this.accountRepository = accountRepository;
    }

    @Override
    public void createBalance(Long accountId, BalanceDto balanceDto) {
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new ResourceNotFoundException("balance", "id", accountId));
        Balance balance = mapToEntity(balanceDto);
        balance.setAccount(account);
        balance.setBalance(0.00);
        balanceRepository.save(balance);
    }

    @Override
    public Double getBalanceByAccountActorId(long accountId) {
        Balance balance = balanceRepository.findByAccountActorId(accountId).orElseThrow(() -> new ResourceNotFoundException("balance", "id", accountId));
        return balance.getBalance();
    }

    private Balance mapToEntity(BalanceDto balanceDto) {
        return modelMapper.map(balanceDto, Balance.class);
    }

    private BalanceDto mapToDto(Balance balance) {
        return modelMapper.map(balance, BalanceDto.class);
    }
}
