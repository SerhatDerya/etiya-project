package com.etiya.customerservice.service.concretes.address;

import com.etiya.common.events.CreateAddressEvent;
import com.etiya.customerservice.domain.entities.Address;
import com.etiya.customerservice.repository.AddressRepository;
import com.etiya.customerservice.service.abstracts.address.AddressService;
import com.etiya.customerservice.service.mappings.address.AddressMapper;
import com.etiya.customerservice.service.requests.address.CreateAddressRequest;
import com.etiya.customerservice.service.responses.address.CreatedAddressResponse;
import com.etiya.customerservice.service.responses.address.GetListAddressResponse;
import com.etiya.customerservice.transport.kafka.producer.address.CreateAddressProducer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private final CreateAddressProducer createAddressProducer;

    public AddressServiceImpl(AddressRepository addressRepository, CreateAddressProducer createAddressProducer) {
        this.addressRepository = addressRepository;
        this.createAddressProducer = createAddressProducer;
    }

    @Override
    public CreatedAddressResponse add(CreateAddressRequest request) {
        Address address = AddressMapper.INSTANCE.addressFromCreateAddressRequest(request);
        Address result = addressRepository.save(address);
        Address fullAddress = addressRepository.findByIdWithCity(result.getId())
                .orElseThrow(() -> new RuntimeException("Address bulunamadı"));
        CreateAddressEvent event = AddressMapper.INSTANCE.createAddressEventFromAddress(fullAddress);
        createAddressProducer.produceAddressCreated(event);
        CreatedAddressResponse response = AddressMapper.INSTANCE.createdAddressResponseFromAddress(result);
        return response;
    }

    @Override
    public List<GetListAddressResponse> getList() {
        List<Address> addresses = addressRepository.findAll();
        return AddressMapper.INSTANCE.getListAddressResponseFromAddress(addresses);
    }
}
