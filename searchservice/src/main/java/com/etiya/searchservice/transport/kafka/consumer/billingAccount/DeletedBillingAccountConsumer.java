package com.etiya.searchservice.transport.kafka.consumer.billingAccount;

import com.etiya.common.events.billingAccount.DeleteBillingAccountEvent;
import com.etiya.searchservice.service.customer.CustomerSearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class DeletedBillingAccountConsumer {
    private final CustomerSearchService customerSearchService;
    private static final Logger LOGGER = LoggerFactory.getLogger(DeletedBillingAccountConsumer.class);

    public DeletedBillingAccountConsumer(CustomerSearchService customerSearchService) {
        this.customerSearchService = customerSearchService;
    }

    @Bean
    public Consumer<DeleteBillingAccountEvent> billingAccountDeleted(){
        return event -> {
            customerSearchService.deleteBillingAccount(event.id(), event.customerId());
            LOGGER.info(String.format("Billing Account deleted event => %s,%s",event.id(),event.customerId()));
        };
    }
}
