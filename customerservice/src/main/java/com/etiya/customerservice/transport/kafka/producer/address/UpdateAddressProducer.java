package com.etiya.customerservice.transport.kafka.producer.address;

import com.etiya.common.events.address.UpdateAddressEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@Service
public class UpdateAddressProducer {

    private final StreamBridge streamBridge;
    private static final Logger LOGGER = LoggerFactory.getLogger(UpdateAddressProducer.class);

    public UpdateAddressProducer(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }


    public void produceAddressUpdated(UpdateAddressEvent event) {
        streamBridge.send("addressUpdated-out-0",event);
        LOGGER.info(String.format("Address updated event => %s,%s,%s",event.id(),event.customerId(),event.cityId()));

    }
}
