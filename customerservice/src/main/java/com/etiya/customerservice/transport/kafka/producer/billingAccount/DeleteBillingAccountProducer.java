package com.etiya.customerservice.transport.kafka.producer.billingAccount;

import com.etiya.common.events.billingAccount.DeleteBillingAccountEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@Service
public class DeleteBillingAccountProducer {
    private final StreamBridge streamBridge;
    private static final Logger LOGGER = LoggerFactory.getLogger(DeleteBillingAccountProducer.class);

    public DeleteBillingAccountProducer(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    public void produceBillingAccountDeleted(DeleteBillingAccountEvent event){
        streamBridge.send("billingAccountDeleted-out-0",event);
        LOGGER.info(String.format("Billing Account deleted event => %s,%s,%s",event.id(),event.customerId()));
    }
}
