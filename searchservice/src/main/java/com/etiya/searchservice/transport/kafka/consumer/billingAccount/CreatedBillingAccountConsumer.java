package com.etiya.searchservice.transport.kafka.consumer.billingAccount;

import com.etiya.common.events.CreateBillingAccountEvent;
import com.etiya.searchservice.domain.BillingAccountSearch;
import com.etiya.searchservice.service.customer.CustomerSearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class CreatedBillingAccountConsumer {

    private final CustomerSearchService customerSearchService;
    private final Logger LOGGER = LoggerFactory.getLogger(CreatedBillingAccountConsumer.class);

    public CreatedBillingAccountConsumer(CustomerSearchService customerSearchService) {
        this.customerSearchService = customerSearchService;
    }

    @Bean
    public Consumer<CreateBillingAccountEvent> billingAccountCreated(){
        return event -> {
            BillingAccountSearch billingAccountSearch = new BillingAccountSearch(
                    event.id(),
                    event.customerId(),
                    event.addressId(),
                    event.statusId(),
                    event.typeId(),
                    event.accountNumber(),
                    event.accountName(),
                    event.typeName(),
                    event.statusName());
            customerSearchService.addBillingAccount(event.customerId(),  billingAccountSearch);
            LOGGER.info(String.format("Billing Account created event => %s,%s,%s",event.id(),event.customerId(),event.addressId()));

        };
    }
}
