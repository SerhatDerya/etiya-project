package com.etiya.customerservice.transport.kafka.producer.contactMedium;

import com.etiya.common.events.contactMedium.UpdateContactMediumEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@Service
public class UpdateContactMediumProducer {
    private final StreamBridge streamBridge;
    private static final Logger LOGGER = LoggerFactory.getLogger(UpdateContactMediumProducer.class);

    public UpdateContactMediumProducer(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    public void produceContactMediumUpdated(UpdateContactMediumEvent event) {
        streamBridge.send("contactMediumUpdated-out-0",event);
        LOGGER.info(String.format("Contact Medium updated event => %s,%s",event.id(),event.customerId()));
    }
}
