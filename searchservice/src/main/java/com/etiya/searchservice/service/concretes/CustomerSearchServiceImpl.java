package com.etiya.searchservice.service.concretes;

import com.etiya.searchservice.domain.AddressSearch;
import com.etiya.searchservice.domain.BillingAccountSearch;
import com.etiya.searchservice.domain.ContactMediumSearch;
import com.etiya.searchservice.domain.CustomerSearch;
import com.etiya.searchservice.repository.CustomerSearchRepository;
import com.etiya.searchservice.service.abstracts.CustomerSearchService;
import com.etiya.searchservice.service.rules.CustomerSearchBusinessRules;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CustomerSearchServiceImpl implements CustomerSearchService {


    private final CustomerSearchRepository customerSearchRepository;
    private final CustomerSearchBusinessRules customerSearchBusinessRules;

    public CustomerSearchServiceImpl(CustomerSearchRepository customerSearchRepository, CustomerSearchBusinessRules customerSearchBusinessRules) {
        this.customerSearchRepository = customerSearchRepository;
        this.customerSearchBusinessRules = customerSearchBusinessRules;
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
    public void addCustomer(CustomerSearch customerSearch) {
        customerSearchRepository.save(customerSearch);
    }

    @Override
    public void deleteCustomer(String id) {
        var deleteCustomer = customerSearchBusinessRules.getCustomerSearchIfExists(id);
        customerSearchRepository.delete(deleteCustomer);
    }

    @Override
    public void updateCustomer(String id, CustomerSearch customerSearch) {
        var updateCustomer = customerSearchBusinessRules.getCustomerSearchIfExists(id);
        updateCustomer.setCustomerNumber(customerSearch.getCustomerNumber());
        updateCustomer.setFirstName(customerSearch.getFirstName());
        updateCustomer.setMiddleName(customerSearch.getMiddleName());
        updateCustomer.setLastName(customerSearch.getLastName());
        updateCustomer.setDateOfBirth(customerSearch.getDateOfBirth());
        updateCustomer.setGender(customerSearch.getGender());
        updateCustomer.setMotherName(customerSearch.getMotherName());
        updateCustomer.setFatherName(customerSearch.getFatherName());
        updateCustomer.setNatId(customerSearch.getNatId());
        customerSearchRepository.save(updateCustomer);
    }

    @Override
    public List<CustomerSearch> searchAllFields(String keyword) {
        return customerSearchRepository.searchAllFields(keyword);
    }

    @Override
    public List<CustomerSearch> searchDynamic(String customerNumber, String accountNumber, String natId, String firstName, String lastName, String mobilePhone) {
        return customerSearchRepository.searchDynamic(customerNumber,accountNumber,natId,firstName,lastName,mobilePhone);
    }

    @Override
    public void addContactMedium(String customerId, ContactMediumSearch contactMediums) {
        var addCustomerContactMedium = customerSearchBusinessRules.getCustomerSearchIfExists(customerId);
        addCustomerContactMedium.getContactMediums().removeIf(cs -> cs.getId().equals(contactMediums.getId()));
        addCustomerContactMedium.getContactMediums().add(contactMediums);
        customerSearchRepository.save(addCustomerContactMedium);
    }

    @Override
    public void updateContactMedium(String customerId, ContactMediumSearch contactMediums) {
        var updateCustomerContactMedium = customerSearchBusinessRules.getCustomerSearchIfExists(customerId);
        updateCustomerContactMedium.getContactMediums().removeIf(cs -> cs.getId().equals(contactMediums.getId()));
        updateCustomerContactMedium.getContactMediums().add(contactMediums);
        customerSearchRepository.save(updateCustomerContactMedium);
    }

    @Override
    public void deleteContactMedium(String id, String customerId) {
        var deleteCustomerContactMedium = customerSearchBusinessRules.getCustomerSearchIfExists(customerId);
        deleteCustomerContactMedium.getContactMediums().removeIf(cs -> cs.getId().equals(id));
        customerSearchRepository.save(deleteCustomerContactMedium);
    }

    @Override
    public void addAddress(String customerId, AddressSearch addressSearch) {
        var addCustomerAddress = customerSearchBusinessRules.getCustomerSearchIfExists(customerId);
        addCustomerAddress.getAddressSearches().removeIf(as -> as.getId().equals(addressSearch.getId()));
        addCustomerAddress.getAddressSearches().add(addressSearch);
        customerSearchRepository.save(addCustomerAddress);
    }

    @Override
    public void updateAddress(String customerId, AddressSearch addressSearch) {
        var updateCustomerAddress = customerSearchBusinessRules.getCustomerSearchIfExists(customerId);
        updateCustomerAddress.getAddressSearches().removeIf(address -> address.getId().equals(addressSearch.getId()));
        updateCustomerAddress.getAddressSearches().add(addressSearch);
        customerSearchRepository.save(updateCustomerAddress);
    }

    @Override
    public void deleteAddress(String id, String customerId) {
        var deleteCustomerAddress = customerSearchBusinessRules.getCustomerSearchIfExists(customerId);
        deleteCustomerAddress.getAddressSearches().removeIf(address -> address.getId().equals(id));
        customerSearchRepository.save(deleteCustomerAddress);
    }

    @Override
    public void addBillingAccount(String customerId, BillingAccountSearch billingAccountSearch) {
        var addCustomerBillingAccount = customerSearchBusinessRules.getCustomerSearchIfExists(customerId);
        addCustomerBillingAccount.getBillingAccountSearches().removeIf(bas -> bas.getId().equals(billingAccountSearch.getId()));
        addCustomerBillingAccount.getBillingAccountSearches().add(billingAccountSearch);
        customerSearchRepository.save(addCustomerBillingAccount);

    }

    @Override
    public void deleteBillingAccount(String id, String customerId) {
        var deleteCustomerBillingAccount = customerSearchBusinessRules.getCustomerSearchIfExists(customerId);
        deleteCustomerBillingAccount.getBillingAccountSearches().removeIf(bas -> bas.getId().equals(id));
        customerSearchRepository.save(deleteCustomerBillingAccount);
    }

    @Override
    public void updateBillingAccount(String customerId, BillingAccountSearch billingAccountSearch) {
        var updateCustomerBillingAccount = customerSearchBusinessRules.getCustomerSearchIfExists(customerId);
        updateCustomerBillingAccount.getBillingAccountSearches().removeIf(bas -> bas.getId().equals(billingAccountSearch.getId()));
        updateCustomerBillingAccount.getBillingAccountSearches().add(billingAccountSearch);
        customerSearchRepository.save(updateCustomerBillingAccount);
    }
}
