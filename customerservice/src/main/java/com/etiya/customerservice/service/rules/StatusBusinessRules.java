package com.etiya.customerservice.service.rules;

import com.etiya.common.crosscuttingconcerns.exceptions.types.BusinessException;
import com.etiya.common.localization.LocalizationService;
import com.etiya.customerservice.repository.StatusRepository;
import com.etiya.customerservice.service.messages.Messages;
import org.springframework.stereotype.Service;

@Service
public class StatusBusinessRules {
    private final StatusRepository statusRepository;
    private final LocalizationService localizationService;

    public StatusBusinessRules(StatusRepository statusRepository, LocalizationService localizationService) {
        this.statusRepository = statusRepository;
        this.localizationService = localizationService;
    }


    public void checkStatusExistsName(String name){
        if(statusRepository.existsByNameIgnoreCase(name)){
            throw new BusinessException(localizationService.getMessage(Messages.StatusExistsName));
        }
    }
}
