package com.etiya.searchservice.service.customer;

import com.etiya.searchservice.domain.AddressSearch;
import com.etiya.searchservice.domain.ContactMediumSearch;
import com.etiya.searchservice.domain.CustomerSearch;
import com.etiya.searchservice.repository.customer.CustomerSearchRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CustomerSearchServiceImpl implements CustomerSearchService {


    private final CustomerSearchRepository customerSearchRepository;

    public CustomerSearchServiceImpl(CustomerSearchRepository customerSearchRepository) {
        this.customerSearchRepository = customerSearchRepository;
    }

    @Override
    public void add(CustomerSearch customerSearch) {
         customerSearchRepository.save(customerSearch);
    }

    @Override
    public List<CustomerSearch> findAll() {
        return StreamSupport.stream(customerSearchRepository.findAll().spliterator(),false).collect(Collectors.toList());
    }

    @Override
    public void delete(String id) {
        customerSearchRepository.deleteById(id);
    }

    @Override
    public List<CustomerSearch> searchAllFields(String keyword) {
        return customerSearchRepository.searchAllFields(keyword);
    }

    @Override
    public List<CustomerSearch> searchDynamic(String id, String accountNumber, String natId, String firstName, String lastName, String mobilePhone) {
        return customerSearchRepository.searchDynamic(id,accountNumber,natId,firstName,lastName,mobilePhone);
    }

    @Override
    public void addContactMedium(String customerId, ContactMediumSearch contactMediums) {
        var addCustomerContactMedium = customerSearchRepository.findById(customerId).orElseThrow(() -> new RuntimeException("Customer not found"));
        addCustomerContactMedium.getContactMediums().removeIf(cs -> cs.getId().equals(contactMediums.getId()));
        addCustomerContactMedium.getContactMediums().add(contactMediums);
        customerSearchRepository.save(addCustomerContactMedium);
    }

    @Override
    public void addAddress(String customerId, AddressSearch addressSearch) {
        var addCustomerAddress = customerSearchRepository.findById(customerId).orElseThrow(() -> new RuntimeException("Customer not found"));
        addCustomerAddress.getAddressSearches().removeIf(as -> as.getId().equals(addressSearch.getId()));
        addCustomerAddress.getAddressSearches().add(addressSearch);
        customerSearchRepository.save(addCustomerAddress);
    }
}
