package ke.co.edwinnjiru.wallet.services;

import ke.co.edwinnjiru.wallet.dtos.BalanceDto;

public interface BalanceService {
    void createBalance(Long accountId, BalanceDto balanceDto);

    Double getBalanceByAccountActorId(long accountId);
}
