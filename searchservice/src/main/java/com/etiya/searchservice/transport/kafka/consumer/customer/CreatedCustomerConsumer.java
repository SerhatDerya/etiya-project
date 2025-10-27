package com.etiya.searchservice.transport.kafka.consumer.customer;

import com.etiya.common.events.CreateCustomerEvent;
import com.etiya.searchservice.domain.CustomerSearch;
import com.etiya.searchservice.service.CustomerSearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

//@Service
@Configuration
public class CreatedCustomerConsumer {

    private final CustomerSearchService customerSearchService;
    private final Logger LOGGER = LoggerFactory.getLogger(CreatedCustomerConsumer.class);

    public CreatedCustomerConsumer(CustomerSearchService customerSearchService) {
        this.customerSearchService = customerSearchService;
    }

    @Bean
    public Consumer<CreateCustomerEvent> customerCreated(){
        return event -> {
            CustomerSearch customerSearch = new CustomerSearch(
                    event.id(),
                    event.firstName(),
                    event.middleName(),
                    event.lastName(),
                    event.dateOfBirth(),
                    event.gender(),
                    event.motherName(),
                    event.fatherName(),
                    event.natId());
            customerSearchService.add(customerSearch);
            LOGGER.info(String.format("Consumed Customer => %s",event.id()));
        };
    }
}
