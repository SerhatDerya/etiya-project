package com.etiya.customerservice.transport.kafka.producer.billingAccount;

import com.etiya.common.events.billingAccount.CreateBillingAccountEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@Service
public class CreateBillingAccountProducer {
    private final StreamBridge streamBridge;
    private static final Logger LOGGER = LoggerFactory.getLogger(CreateBillingAccountProducer.class);

    public CreateBillingAccountProducer(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    public void produceBillingAccountCreated(CreateBillingAccountEvent event){
        streamBridge.send("billingAccountCreated-out-0",event);
        LOGGER.info(String.format("Billing Account created event => %s,%s,%s",event.id(),event.customerId(),event.addressId()));
    }
}
