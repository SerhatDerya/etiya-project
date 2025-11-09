package com.etiya.customerservice.service.concretes;

import com.etiya.common.events.contactMedium.CreateContactMediumEvent;
import com.etiya.common.events.contactMedium.DeleteContactMediumEvent;
import com.etiya.common.events.contactMedium.UpdateContactMediumEvent;
import com.etiya.customerservice.domain.entities.ContactMedium;
import com.etiya.customerservice.repository.ContactMediumRepository;
import com.etiya.customerservice.service.abstracts.ContactMediumService;
import com.etiya.customerservice.service.mappings.ContactMediumMapper;
import com.etiya.customerservice.service.requests.contactMedium.CreateContactMediumRequest;
import com.etiya.customerservice.service.requests.contactMedium.UpdateContactMediumRequest;
import com.etiya.customerservice.service.responses.contactMedium.CreatedContactMediumResponse;
import com.etiya.customerservice.service.responses.contactMedium.GetListContactMediumResponse;
import com.etiya.customerservice.service.responses.contactMedium.UpdatedContactMediumResponse;
import com.etiya.customerservice.transport.kafka.producer.contactMedium.CreateContactMediumProducer;
import com.etiya.customerservice.transport.kafka.producer.contactMedium.DeleteContactMediumProducer;
import com.etiya.customerservice.transport.kafka.producer.contactMedium.UpdateContactMediumProducer;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class ContactMediumServiceImpl implements ContactMediumService {

    private final ContactMediumRepository contactMediumRepository;
    private final CreateContactMediumProducer createContactMediumProducer;
    private final UpdateContactMediumProducer updateContactMediumProducer;
    private final DeleteContactMediumProducer deleteContactMediumProducer;

    public ContactMediumServiceImpl(ContactMediumRepository contactMediumRepository, CreateContactMediumProducer createContactMediumProducer, UpdateContactMediumProducer updateContactMediumProducer, DeleteContactMediumProducer deleteContactMediumProducer) {
        this.contactMediumRepository = contactMediumRepository;
        this.createContactMediumProducer = createContactMediumProducer;
        this.updateContactMediumProducer = updateContactMediumProducer;
        this.deleteContactMediumProducer = deleteContactMediumProducer;
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
    public List<GetListContactMediumResponse> getList() {
        List<ContactMedium> result = contactMediumRepository.findAll();
        return ContactMediumMapper.INSTANCE.getListContactMediumResponseFromContactMedium(result);
    }

    @Override
    public UpdatedContactMediumResponse update(UUID id, UpdateContactMediumRequest request) {
        ContactMedium contactMedium = contactMediumRepository.findById(id).orElseThrow(() -> new RuntimeException("Contact Medium could not found"));
        ContactMediumMapper.INSTANCE.contactMediumFromUpdateContactMediumRequest(request, contactMedium);
        ContactMedium result = contactMediumRepository.save(contactMedium);
        UpdateContactMediumEvent event =  ContactMediumMapper.INSTANCE.updateContactMediumEventFromContactMedium(result);
        updateContactMediumProducer.produceContactMediumUpdated(event);
        contactMedium.setUpdatedDate(LocalDateTime.now());
        UpdatedContactMediumResponse response = ContactMediumMapper.INSTANCE.updatedContactMediumResponseFromContactMedium(result);
        return response;
    }

    @Override
    public void delete(UUID id) {
        ContactMedium contactMedium = contactMediumRepository.findById(id).orElseThrow(() -> new RuntimeException("Contact Medium could not found"));
        DeleteContactMediumEvent event = new DeleteContactMediumEvent(
                contactMedium.getId().toString(),
                contactMedium.getCustomer().getId().toString()
        );
        deleteContactMediumProducer.produceContactMediumDeleted(event);
        contactMedium.setDeletedDate(LocalDateTime.now());
        contactMediumRepository.save(contactMedium);
    }
}
