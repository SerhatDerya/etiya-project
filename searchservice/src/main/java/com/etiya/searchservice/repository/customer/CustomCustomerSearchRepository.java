package com.etiya.searchservice.repository.customer;

import com.etiya.searchservice.domain.CustomerSearch;

import java.util.List;

public interface CustomCustomerSearchRepository {
    List<CustomerSearch> searchDynamic(
            String id,
            String accountNumber,
            String natId,
            String firstName,
            String lastName,
            String mobilePhone
    );
}
