package com.etiya.customerservice.service.concretes;

import com.etiya.common.events.address.CreateAddressEvent;
import com.etiya.common.events.address.DeleteAddressEvent;
import com.etiya.common.events.address.UpdateAddressEvent;
import com.etiya.customerservice.domain.entities.Address;
import com.etiya.customerservice.domain.entities.City;
import com.etiya.customerservice.repository.AddressRepository;
import com.etiya.customerservice.repository.CityRepository;
import com.etiya.customerservice.service.abstracts.AddressService;
import com.etiya.customerservice.service.mappings.AddressMapper;
import com.etiya.customerservice.service.requests.address.CreateAddressRequest;
import com.etiya.customerservice.service.requests.address.UpdateAddressRequest;
import com.etiya.customerservice.service.responses.address.CreatedAddressResponse;
import com.etiya.customerservice.service.responses.address.GetListAddressResponse;
import com.etiya.customerservice.service.responses.address.UpdatedAddressResponse;
import com.etiya.customerservice.service.rules.AddressBusinessRules;
import com.etiya.customerservice.service.rules.CityBusinessRules;
import com.etiya.customerservice.service.rules.CustomerBusinessRules;
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
    private final CityRepository cityRepository;
    private final CreateAddressProducer createAddressProducer;
    private final UpdateAddressProducer updateAddressProducer;
    private final DeleteAddressProducer deleteAddressProducer;
    private final CustomerBusinessRules customerBusinessRules;
    private final AddressBusinessRules addressBusinessRules;
    private final CityBusinessRules cityBusinessRules;

    public AddressServiceImpl(AddressRepository addressRepository, CityRepository cityRepository, CreateAddressProducer createAddressProducer, UpdateAddressProducer updateAddressProducer, DeleteAddressProducer deleteAddressProducer, CustomerBusinessRules customerBusinessRules, AddressBusinessRules addressBusinessRules, CityBusinessRules cityBusinessRules) {
        this.addressRepository = addressRepository;
        this.cityRepository = cityRepository;
        this.createAddressProducer = createAddressProducer;
        this.updateAddressProducer = updateAddressProducer;
        this.deleteAddressProducer = deleteAddressProducer;
        this.customerBusinessRules = customerBusinessRules;
        this.addressBusinessRules = addressBusinessRules;
        this.cityBusinessRules = cityBusinessRules;
    }

    @Override
    public CreatedAddressResponse add(CreateAddressRequest request) {
        customerBusinessRules.checkIfCustomerNotDeleted(request.getCustomerId());
        Address address = AddressMapper.INSTANCE.addressFromCreateAddressRequest(request);
        Address result = addressRepository.save(address);
        Address fullAddress = addressBusinessRules.getAddressWithCityIfExists(result.getId());
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
        Address address = addressBusinessRules.getAddressIfExists(id);
        AddressMapper.INSTANCE.addressFromUpdateAddressRequest(request, address);
        City city = cityBusinessRules.getCityIfExists(request.getCityId());
        address.setCity(city);
        Address result = addressRepository.save(address);
        Address fullAddress = addressBusinessRules.getAddressWithCityIfExists(result.getId());
        UpdateAddressEvent event = AddressMapper.INSTANCE.updateAddressEventFromAddress(fullAddress);
        updateAddressProducer.produceAddressUpdated(event);
        address.setUpdatedDate(LocalDateTime.now());
        UpdatedAddressResponse response = AddressMapper.INSTANCE.updatedAddressResponseFromAddress(result);
        return response;
    }

    @Override
    public void delete(UUID id) {
        Address address = addressBusinessRules.getAddressIfExists(id);
        DeleteAddressEvent event = new DeleteAddressEvent(
                address.getId().toString(),
                address.getCustomer().getId().toString()
        );
        deleteAddressProducer.produceAddressDeleted(event);
        address.setDeletedDate(LocalDateTime.now());
        addressRepository.save(address);
    }


}
