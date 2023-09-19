package ke.co.edwinnjiru.wallet.services;

import ke.co.edwinnjiru.wallet.dtos.PhoneDto;

import java.util.List;

public interface PhoneService {
    void createPhone(long customerId, PhoneDto phoneDto);

    List<PhoneDto> getPhoneByCustomerId(long customerId);
}
