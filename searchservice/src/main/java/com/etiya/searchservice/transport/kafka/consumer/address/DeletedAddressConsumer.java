package com.etiya.searchservice.transport.kafka.consumer.address;

import com.etiya.common.events.address.DeleteAddressEvent;
import com.etiya.searchservice.service.customer.CustomerSearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class DeletedAddressConsumer {
    private final CustomerSearchService customerSearchService;
    private static final Logger LOGGER =  LoggerFactory.getLogger(DeletedAddressConsumer.class);

    public DeletedAddressConsumer(CustomerSearchService customerSearchService) {
        this.customerSearchService = customerSearchService;
    }
    @Bean
    public Consumer<DeleteAddressEvent> addressDeleted(){
        return event -> {
            customerSearchService.deleteAddress(event.id(),event.customerId());
            LOGGER.info(String.format("Address deleted event => %s,%s",event.id(),event.customerId()));
        };
    }
}
