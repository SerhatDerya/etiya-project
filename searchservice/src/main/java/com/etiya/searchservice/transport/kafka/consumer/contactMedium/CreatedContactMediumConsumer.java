package com.etiya.searchservice.transport.kafka.consumer.contactMedium;

import com.etiya.common.events.contactMedium.CreateContactMediumEvent;
import com.etiya.searchservice.domain.ContactMediumSearch;
import com.etiya.searchservice.service.abstracts.CustomerSearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class CreatedContactMediumConsumer {
    private final CustomerSearchService customerSearchService;
    private final Logger LOGGER =  LoggerFactory.getLogger(CreatedContactMediumConsumer.class);

    public CreatedContactMediumConsumer(CustomerSearchService customerSearchService) {
        this.customerSearchService = customerSearchService;

    }
    @Bean
    public Consumer<CreateContactMediumEvent> contactMediumCreated(){
        return event -> {
            ContactMediumSearch contactMediumSearch = new ContactMediumSearch(
                    event.id(),
                    event.email(),
                    event.homePhone(),
                    event.mobilePhone(),
                    event.fax(),
                    event.customerId());
            customerSearchService.addContactMedium(event.customerId(),contactMediumSearch);
            LOGGER.info(String.format("Contact Medium created event => %s,%s",event.id(),event.customerId()));
        };
    }
}
