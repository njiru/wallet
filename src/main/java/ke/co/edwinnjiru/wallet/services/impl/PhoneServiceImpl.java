package ke.co.edwinnjiru.wallet.services.impl;

import ke.co.edwinnjiru.wallet.dtos.PhoneDto;
import ke.co.edwinnjiru.wallet.exceptions.ResourceNotFoundException;
import ke.co.edwinnjiru.wallet.models.customerSchema.Customer;
import ke.co.edwinnjiru.wallet.models.customerSchema.Phone;
import ke.co.edwinnjiru.wallet.repositories.CustomerRepository;
import ke.co.edwinnjiru.wallet.repositories.PhoneRepository;
import ke.co.edwinnjiru.wallet.services.PhoneService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneServiceImpl implements PhoneService {

    private final PhoneRepository phoneRepository;
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    public PhoneServiceImpl(PhoneRepository phoneRepository, ModelMapper modelMapper, CustomerRepository customerRepository) {
        this.phoneRepository = phoneRepository;
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void createPhone(long customerId, PhoneDto phoneDto) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new ResourceNotFoundException("customer", "id", customerId));
        Phone phone = mapToEntity(phoneDto);
        phone.setCustomer(customer);

        phoneRepository.save(phone);
    }

    @Override
    public List<PhoneDto> getPhoneByCustomerId(long customerId) {
        List<Phone> phones = phoneRepository.findByCustomerActorId(customerId);
        return phones.stream().map(this::mapToDto).toList();
    }

    private Phone mapToEntity(PhoneDto phoneDto) {
        return modelMapper.map(phoneDto, Phone.class);
    }

    private PhoneDto mapToDto(Phone phone) {
        return modelMapper.map(phone, PhoneDto.class);
    }
}
