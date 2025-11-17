package com.etiya.searchservice.transport.kafka.consumer.address;

import com.etiya.common.events.address.UpdateAddressEvent;
import com.etiya.searchservice.domain.AddressSearch;
import com.etiya.searchservice.service.abstracts.CustomerSearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class UpdatedAddressConsumer {
    private final CustomerSearchService customerSearchService;
    private final Logger LOGGER = LoggerFactory.getLogger(UpdatedAddressConsumer.class);


    public UpdatedAddressConsumer(CustomerSearchService customerSearchService) {
        this.customerSearchService = customerSearchService;
    }

    @Bean
    public Consumer<UpdateAddressEvent> addressUpdated() {
        return event -> {
            AddressSearch addressSearch = new AddressSearch(
                    event.id(),
                    event.title(),
                    event.street(),
                    event.houseNumber(),
                    event.description(),
                    event.isDefault(),
                    event.customerId(),
                    event.cityId(),
                    event.cityName());
            customerSearchService.updateAddress(event.customerId(), addressSearch);
            LOGGER.info(String.format("Address updated event => %s,%s,%s", event.id(), event.customerId(), event.cityId()));
        };
    }
}
