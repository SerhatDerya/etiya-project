package com.etiya.customerservice.transport.kafka.producer.billingAccount;

import com.etiya.common.events.billingAccount.CreateBillingAccountEvent;
import com.etiya.common.events.billingAccount.UpdateBillingAccountEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@Service
public class UpdateBillingAccountProducer {
    private final StreamBridge streamBridge;
    private static final Logger LOGGER = LoggerFactory.getLogger(UpdateBillingAccountProducer.class);

    public UpdateBillingAccountProducer(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    public void produceBillingAccountUpdated(UpdateBillingAccountEvent event){
        streamBridge.send("billingAccountUpdated-out-0",event);
        LOGGER.info(String.format("Billing Account updated event => %s,%s,%s",event.id(),event.customerId(),event.addressId()));
    }
}
