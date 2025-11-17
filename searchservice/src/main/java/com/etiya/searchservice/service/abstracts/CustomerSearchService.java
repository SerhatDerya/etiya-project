package com.etiya.searchservice.service.abstracts;

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
            String customerNumber,
            String accountNumber,
            String natId,
            String firstName,
            String lastName,
            String mobilePhone
    );

    void addCustomer(CustomerSearch customerSearch);
    void deleteCustomer(String id);
    void updateCustomer(String id, CustomerSearch customerSearch);

    void addAddress(String customerId, AddressSearch addressSearch);
    void updateAddress(String customerId, AddressSearch addressSearch);
    void deleteAddress(String id,String customerId);

    void addContactMedium(String customerId, ContactMediumSearch contactMediums);
    void updateContactMedium(String customerId, ContactMediumSearch contactMediums);
    void deleteContactMedium(String id, String customerId);

    void addBillingAccount(String customerId, BillingAccountSearch billingAccountSearch);
    void deleteBillingAccount(String id,String customerId);
    void updateBillingAccount(String customerId, BillingAccountSearch billingAccountSearch);


}
