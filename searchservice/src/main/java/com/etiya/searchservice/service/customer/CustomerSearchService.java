package com.etiya.searchservice.service.customer;

import com.etiya.searchservice.domain.AddressSearch;
import com.etiya.searchservice.domain.BillingAccountSearch;
import com.etiya.searchservice.domain.ContactMediumSearch;
import com.etiya.searchservice.domain.CustomerSearch;

import java.util.List;

public interface CustomerSearchService {

    void delete(String id);

    List<CustomerSearch> findAll();
    List<CustomerSearch> searchAllFields(String keyword);
    List<CustomerSearch> searchDynamic(
            String id,
            String accountNumber,
            String natId,
            String firstName,
            String lastName,
            String mobilePhone
    );

    void addCustomer(CustomerSearch customerSearch);
    void deleteCustomer(String id);
    void updateCustomer(String id, CustomerSearch customerSearch);

    void addContactMedium(String customerId, ContactMediumSearch contactMediums);
    void addAddress(String customerId, AddressSearch addressSearch);
    void addBillingAccount(String customerId, BillingAccountSearch billingAccountSearch);


}
