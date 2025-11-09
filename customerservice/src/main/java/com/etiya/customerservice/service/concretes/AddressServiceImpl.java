package com.etiya.customerservice.service.concretes;

import com.etiya.common.events.address.CreateAddressEvent;
import com.etiya.common.events.address.DeleteAddressEvent;
import com.etiya.common.events.address.UpdateAddressEvent;
import com.etiya.customerservice.domain.entities.Address;
import com.etiya.customerservice.repository.AddressRepository;
import com.etiya.customerservice.service.abstracts.AddressService;
import com.etiya.customerservice.service.mappings.AddressMapper;
import com.etiya.customerservice.service.requests.address.CreateAddressRequest;
import com.etiya.customerservice.service.requests.address.UpdateAddressRequest;
import com.etiya.customerservice.service.responses.address.CreatedAddressResponse;
import com.etiya.customerservice.service.responses.address.GetListAddressResponse;
import com.etiya.customerservice.service.responses.address.UpdatedAddressResponse;
import com.etiya.customerservice.service.rules.customer.CustomerBusinessRules;
import com.etiya.customerservice.transport.kafka.producer.address.CreateAddressProducer;
import com.etiya.customerservice.transport.kafka.producer.address.DeleteAddressProducer;
import com.etiya.customerservice.transport.kafka.producer.address.UpdateAddressProducer;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private final CreateAddressProducer createAddressProducer;
    private final UpdateAddressProducer updateAddressProducer;
    private final DeleteAddressProducer deleteAddressProducer;
    private final CustomerBusinessRules customerBusinessRules;

    public AddressServiceImpl(AddressRepository addressRepository, CreateAddressProducer createAddressProducer, UpdateAddressProducer updateAddressProducer, DeleteAddressProducer deleteAddressProducer, CustomerBusinessRules customerBusinessRules) {
        this.addressRepository = addressRepository;
        this.createAddressProducer = createAddressProducer;
        this.updateAddressProducer = updateAddressProducer;
        this.deleteAddressProducer = deleteAddressProducer;
        this.customerBusinessRules = customerBusinessRules;
    }

    @Override
    public CreatedAddressResponse add(CreateAddressRequest request) {
        customerBusinessRules.checkIfCustomerNotDeleted(request.getCustomerId());
        Address address = AddressMapper.INSTANCE.addressFromCreateAddressRequest(request);
        Address result = addressRepository.save(address);
        Address fullAddress = addressRepository.findByIdWithCity(result.getId())
                .orElseThrow(() -> new RuntimeException("Address could not found"));
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

    @Override
    public UpdatedAddressResponse update(UUID id, UpdateAddressRequest request) {
        Address address = addressRepository.findById(id).orElseThrow(() -> new RuntimeException("Address could not found"));
        AddressMapper.INSTANCE.addressFromUpdateAddressRequest(request, address);
        Address result = addressRepository.save(address);
        Address fullAddress = addressRepository.findByIdWithCity(result.getId()).orElseThrow(() -> new RuntimeException("City could not found with this address"));
        UpdateAddressEvent event = AddressMapper.INSTANCE.updateAddressEventFromAddress(fullAddress);
        updateAddressProducer.produceAddressUpdated(event);
        address.setUpdatedDate(LocalDateTime.now());
        UpdatedAddressResponse response = AddressMapper.INSTANCE.updatedAddressResponseFromAddress(result);
        return response;
    }

    @Override
    public void delete(UUID id) {
        Address address = addressRepository.findById(id).orElseThrow(() -> new RuntimeException("Address could not found"));
        DeleteAddressEvent event = new DeleteAddressEvent(
                address.getId().toString(),
                address.getCustomer().getId().toString()
        );
        deleteAddressProducer.produceAddressDeleted(event);
        address.setDeletedDate(LocalDateTime.now());
        addressRepository.save(address);
    }


}
