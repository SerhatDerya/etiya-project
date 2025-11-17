package com.etiya.searchservice.transport.kafka.consumer.contactMedium;

import com.etiya.common.events.contactMedium.DeleteContactMediumEvent;
import com.etiya.searchservice.service.abstracts.CustomerSearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class DeletedContactMediumConsumer {
    private final CustomerSearchService customerSearchService;
    private final Logger LOGGER = LoggerFactory.getLogger(DeletedContactMediumConsumer.class);

    public DeletedContactMediumConsumer(CustomerSearchService customerSearchService) {
        this.customerSearchService = customerSearchService;

    }

    @Bean
    public Consumer<DeleteContactMediumEvent> contactMediumDeleted(){
        return event -> {
            customerSearchService.deleteContactMedium(event.id(), event.customerId());
            LOGGER.info(String.format("Contact Medium deleted event => %s,%s",event.id(),event.customerId()));
        };
    }
}
