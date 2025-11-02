package com.etiya.customerservice.service.rules.customer;

import com.etiya.common.crosscuttingconcerns.exceptions.types.BusinessException;
import com.etiya.common.localization.LocalizationService;
import com.etiya.customerservice.repository.CustomerRepository;
import com.etiya.customerservice.service.messages.Messages;
import org.springframework.stereotype.Service;

@Service
public class CustomerBusinessRules {
    private final CustomerRepository customerRepository;
    private final LocalizationService localizationService;

    public CustomerBusinessRules(CustomerRepository customerRepository, LocalizationService localizationService) {
        this.customerRepository = customerRepository;
        this.localizationService = localizationService;
    }


    public void checkIfCustomerExistsByIdentityNumber(String identityNumber) {
        if(customerRepository.existsByNatId(identityNumber)){
            throw new BusinessException(localizationService.getMessage(Messages.NationalIdentityExists));
        }
    }


}
