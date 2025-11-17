package com.etiya.searchservice.service.rules;

import com.etiya.common.crosscuttingconcerns.exceptions.types.BusinessException;
import com.etiya.common.localization.LocalizationService;
import com.etiya.searchservice.domain.CustomerSearch;
import com.etiya.searchservice.repository.CustomerSearchRepository;
import com.etiya.searchservice.service.messages.Messages;
import org.springframework.stereotype.Service;

@Service
public class CustomerSearchBusinessRules {
    private final CustomerSearchRepository customerSearchRepository;
    private final LocalizationService localizationService;

    public CustomerSearchBusinessRules(CustomerSearchRepository customerSearchRepository, LocalizationService localizationService) {
        this.customerSearchRepository = customerSearchRepository;
        this.localizationService = localizationService;
    }

    public CustomerSearch getCustomerSearchIfExists(String id) {
        return customerSearchRepository.findById(id)
                .orElseThrow(() -> new BusinessException(localizationService.getMessage(Messages.CustomerNotFound)));
    }
}
