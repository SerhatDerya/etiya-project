package com.etiya.customerservice.service.rules;

import com.etiya.common.crosscuttingconcerns.exceptions.types.BusinessException;
import com.etiya.common.localization.LocalizationService;
import com.etiya.customerservice.repository.TypeRepository;
import com.etiya.customerservice.service.messages.Messages;
import org.springframework.stereotype.Service;

@Service
public class TypeBusinessRules {
    private final TypeRepository typeRepository;
    private final LocalizationService localizationService;

    public TypeBusinessRules(TypeRepository typeRepository, LocalizationService localizationService) {
        this.typeRepository = typeRepository;
        this.localizationService = localizationService;
    }

    public void checkTypeExistsName(String name){
        if(typeRepository.existsByNameIgnoreCase(name)){
            throw new BusinessException(localizationService.getMessage(Messages.TypeExistsName));
        }
    }
}
