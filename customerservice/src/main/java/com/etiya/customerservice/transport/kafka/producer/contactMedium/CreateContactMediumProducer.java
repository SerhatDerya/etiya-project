package com.etiya.customerservice.transport.kafka.producer.contactMedium;


import com.etiya.common.events.CreateContactMediumEvent;
import com.etiya.customerservice.repository.ContactMediumRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@Service
public class CreateContactMediumProducer {

    private final StreamBridge streamBridge;
    private static final Logger LOGGER = LoggerFactory.getLogger(CreateContactMediumProducer.class);

    public CreateContactMediumProducer(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    public void produceContactMediumCreated(CreateContactMediumEvent event) {
        streamBridge.send("contactMediumCreated-out-0", event);
        LOGGER.info(String.format("Contact Medium created event => %s,%s",event.id(),event.customerId()));
    }
}
