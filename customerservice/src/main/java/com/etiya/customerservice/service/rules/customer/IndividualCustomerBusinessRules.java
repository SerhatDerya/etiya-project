package com.etiya.customerservice.service.rules.customer;

import com.etiya.common.crosscuttingconcerns.exceptions.types.BusinessException;
import com.etiya.common.localization.LocalizationService;
import com.etiya.customerservice.domain.entities.IndividualCustomer;
import com.etiya.customerservice.repository.IndividualCustomerRepository;
import com.etiya.customerservice.service.messages.Messages;
import org.springframework.stereotype.Service;

@Service
public class IndividualCustomerBusinessRules extends CustomerBusinessRules<IndividualCustomer>{
    private final IndividualCustomerRepository individualCustomerRepository;
    private final LocalizationService localizationService;

    public IndividualCustomerBusinessRules(IndividualCustomerRepository individualCustomerRepository, LocalizationService localizationService) {
        super(individualCustomerRepository, localizationService);
        this.individualCustomerRepository = individualCustomerRepository;
        this.localizationService = localizationService;
    }


    public void checkIfIndividualCustomerExistsByIdentityNumber(String identityNumber) {
        if(individualCustomerRepository.existsByNatId(identityNumber)){
            throw new BusinessException(localizationService.getMessage(Messages.NationalIdentityExists));
        }
    }

}
