package com.etiya.customerservice.service.concretes;

import com.etiya.common.events.contactMedium.CreateContactMediumEvent;
import com.etiya.customerservice.domain.entities.ContactMedium;
import com.etiya.customerservice.repository.ContactMediumRepository;
import com.etiya.customerservice.service.abstracts.ContactMediumService;
import com.etiya.customerservice.service.mappings.ContactMediumMapper;
import com.etiya.customerservice.service.requests.contactMedium.CreateContactMediumRequest;
import com.etiya.customerservice.service.responses.contactMedium.CreatedContactMediumResponse;
import com.etiya.customerservice.service.responses.contactMedium.GetListContactMediumReponse;
import com.etiya.customerservice.transport.kafka.producer.contactMedium.CreateContactMediumProducer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactMediumServiceImpl implements ContactMediumService {

    private final ContactMediumRepository contactMediumRepository;
    private final CreateContactMediumProducer createContactMediumProducer;

    public ContactMediumServiceImpl(ContactMediumRepository contactMediumRepository, CreateContactMediumProducer createContactMediumProducer) {
        this.contactMediumRepository = contactMediumRepository;
        this.createContactMediumProducer = createContactMediumProducer;
    }

    @Override
    public CreatedContactMediumResponse add(CreateContactMediumRequest request) {
        ContactMedium contactMedium = ContactMediumMapper.INSTANCE.contactMediumFromCreateContactMediumRequest(request);
        ContactMedium result = contactMediumRepository.save(contactMedium);
        CreateContactMediumEvent event = ContactMediumMapper.INSTANCE.createContactMediumEventFromContactMedium(result);
        createContactMediumProducer.produceContactMediumCreated(event);
        CreatedContactMediumResponse response = ContactMediumMapper.INSTANCE.createdContactMediumResponseFromContactMedium(result);
        return response;
    }

    @Override
    public List<GetListContactMediumReponse> getList() {
        List<ContactMedium> result = contactMediumRepository.findAll();
        return ContactMediumMapper.INSTANCE.getListContactMediumResponseFromContactMedium(result);
    }
}
