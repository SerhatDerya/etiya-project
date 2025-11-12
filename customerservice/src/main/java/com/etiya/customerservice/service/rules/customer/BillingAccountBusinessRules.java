package com.etiya.customerservice.service.rules.customer;

import com.etiya.common.crosscuttingconcerns.exceptions.types.BusinessException;
import com.etiya.common.localization.LocalizationService;
import com.etiya.customerservice.domain.entities.BillingAccount;
import com.etiya.customerservice.domain.entities.Status;
import com.etiya.customerservice.domain.entities.Type;
import com.etiya.customerservice.repository.BillingAccountRepository;
import com.etiya.customerservice.repository.StatusRepository;
import com.etiya.customerservice.repository.TypeRepository;
import com.etiya.customerservice.service.messages.Messages;
import org.springframework.stereotype.Service;

@Service
public class BillingAccountBusinessRules {
    private final BillingAccountRepository billingAccountRepository;
    private final StatusRepository statusRepository;
    private final TypeRepository typeRepository;
    private final LocalizationService localizationService;

    public BillingAccountBusinessRules(BillingAccountRepository billingAccountRepository, StatusRepository statusRepository, TypeRepository typeRepository, LocalizationService localizationService) {
        this.billingAccountRepository = billingAccountRepository;
        this.statusRepository = statusRepository;
        this.typeRepository = typeRepository;
        this.localizationService = localizationService;
    }

    public void setDefaultStatusIfNull(BillingAccount billingAccount) {
        if (billingAccount.getStatus() == null) {
            Status status = statusRepository.findByName("ACTIVE")
                    .orElseThrow(() -> new BusinessException(
                            localizationService.getMessage(Messages.ActiveStatusNotFound)
                    ));

            billingAccount.setStatus(status);
        }
    }
    public void setDefaultTypeIfNull(BillingAccount billingAccount) {
        if (billingAccount.getType() == null) {
            Type type = typeRepository.findByName("BILLING")
                    .orElseThrow(() -> new BusinessException(
                            localizationService.getMessage(Messages.BillingTypeNotFound)
                    ));

            billingAccount.setType(type);
        }
    }
    public void setClosedStatus(BillingAccount billingAccount) {
        Status closedStatus = statusRepository.findByName("CLOSED")
                .orElseThrow(() -> new BusinessException(
                        localizationService.getMessage(Messages.ClosedStatusNotFound)
                ));
        billingAccount.setStatus(closedStatus);
    }
}
