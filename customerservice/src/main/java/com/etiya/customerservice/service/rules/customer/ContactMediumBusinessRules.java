package com.etiya.customerservice.service.rules.customer;

import com.etiya.common.crosscuttingconcerns.exceptions.types.BusinessException;
import com.etiya.common.localization.LocalizationService;
import com.etiya.customerservice.domain.entities.Customer;
import com.etiya.customerservice.repository.ContactMediumRepository;
import com.etiya.customerservice.service.messages.Messages;
import org.springframework.stereotype.Service;

@Service
public class ContactMediumBusinessRules {
    private final ContactMediumRepository contactMediumRepository;
    private final LocalizationService localizationService;

    public ContactMediumBusinessRules(ContactMediumRepository contactMediumRepository, LocalizationService localizationService) {
        this.contactMediumRepository = contactMediumRepository;
        this.localizationService = localizationService;
    }

}
