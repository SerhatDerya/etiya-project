package com.etiya.customerservice.service.rules;

import com.etiya.common.crosscuttingconcerns.exceptions.types.BusinessException;
import com.etiya.common.localization.LocalizationService;
import com.etiya.customerservice.domain.entities.IndividualCustomer;
import com.etiya.customerservice.repository.IndividualCustomerRepository;
import com.etiya.customerservice.service.messages.Messages;
import org.springframework.stereotype.Service;

import java.util.UUID;

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

    public void checkIfIndividualCustomerExistsByIdentityNumberExceptCurrent(String natId, UUID id) {
        IndividualCustomer existCustomer = individualCustomerRepository.findByNatId(natId);
        if (existCustomer !=null && !existCustomer.getId().equals(id)) {
            throw new BusinessException(localizationService.getMessage(Messages.NationalIdentityExists));
        }
    }

    public IndividualCustomer getIndividualCustomerIfExists(UUID id) {
       return individualCustomerRepository.findById(id)
               .orElseThrow(() -> new BusinessException(localizationService.getMessage(Messages.IndividualCustomerNotFound)));
    }


}
