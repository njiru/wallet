package ke.co.edwinnjiru.newwallet.services.impl;

import ke.co.edwinnjiru.newwallet.dtos.customerDtos.PhoneDto;
import ke.co.edwinnjiru.newwallet.models.customerSchema.Customer;
import ke.co.edwinnjiru.newwallet.models.customerSchema.Phone;
import ke.co.edwinnjiru.newwallet.repositories.PhoneRepository;
import ke.co.edwinnjiru.newwallet.services.PhoneService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class PhoneServiceImpl implements PhoneService {

    private final PhoneRepository phoneRepository;
    private final ModelMapper modelMapper;

    public PhoneServiceImpl(PhoneRepository phoneRepository, ModelMapper modelMapper) {
        this.phoneRepository = phoneRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void createPhone(PhoneDto phoneDto, Customer customer) {
        Phone phone = modelMapper.map(phoneDto, Phone.class);
        phone.setCustomer(customer);
        phoneRepository.save(phone);
    }
}
