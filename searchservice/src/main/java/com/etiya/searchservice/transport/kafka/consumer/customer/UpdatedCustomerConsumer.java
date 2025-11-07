package com.etiya.searchservice.transport.kafka.consumer.customer;

import com.etiya.common.events.customer.UpdateCustomerEvent;
import com.etiya.searchservice.domain.CustomerSearch;
import com.etiya.searchservice.service.customer.CustomerSearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class UpdatedCustomerConsumer {
    private final CustomerSearchService customerSearchService;
    private final Logger LOGGER =  LoggerFactory.getLogger(UpdatedCustomerConsumer.class);

    public UpdatedCustomerConsumer(CustomerSearchService customerSearchService) {
        this.customerSearchService = customerSearchService;
    }

    @Bean
    public Consumer<UpdateCustomerEvent> customerUpdated(){
        return event -> {
            CustomerSearch customerSearch = new CustomerSearch(
                    event.id(),
                    event.customerNumber(),
                    event.firstName(),
                    event.middleName(),
                    event.lastName(),
                    event.dateOfBirth(),
                    event.gender(),
                    event.motherName(),
                    event.fatherName(),
                    event.natId());
            customerSearchService.updateCustomer(event.id(), customerSearch);
            LOGGER.info(String.format("Customer updated event => %s", event.id()));
        };
    }

}
