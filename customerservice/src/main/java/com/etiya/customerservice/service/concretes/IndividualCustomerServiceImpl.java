package com.etiya.customerservice.service.concretes;

import com.etiya.common.events.customer.CreateCustomerEvent;
import com.etiya.common.events.customer.DeleteCustomerEvent;
import com.etiya.common.events.customer.UpdateCustomerEvent;
import com.etiya.customerservice.domain.entities.IndividualCustomer;
import com.etiya.customerservice.repository.IndividualCustomerRepository;
import com.etiya.customerservice.service.requests.customer.UpdateIndividualCustomerRequest;
import com.etiya.customerservice.service.responses.customer.UpdatedIndividualCustomerResponse;
import com.etiya.customerservice.service.rules.customer.IndividualCustomerBusinessRules;
import com.etiya.customerservice.service.abstracts.IndividualCustomerService;
import com.etiya.customerservice.service.mappings.IndividualCustomerMapper;
import com.etiya.customerservice.service.requests.customer.CreateIndividualCustomerRequest;
import com.etiya.customerservice.service.responses.customer.CreatedIndividualCustomerResponse;
import com.etiya.customerservice.service.responses.customer.GetListIndividualCustomerResponse;
import com.etiya.customerservice.transport.kafka.producer.customer.CreateCustomerProducer;
import com.etiya.customerservice.transport.kafka.producer.customer.DeleteCustomerProducer;
import com.etiya.customerservice.transport.kafka.producer.customer.UpdateCustomerProducer;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class IndividualCustomerServiceImpl implements IndividualCustomerService {
    private final IndividualCustomerRepository individualCustomerRepository;
    private final CreateCustomerProducer createCustomerProducer;
    private final DeleteCustomerProducer deleteCustomerProducer;
    private final UpdateCustomerProducer updateCustomerProducer;
    private final IndividualCustomerBusinessRules individualCustomerBusinessRules;

    public IndividualCustomerServiceImpl(IndividualCustomerRepository individualCustomerRepository, CreateCustomerProducer createCustomerProducer, DeleteCustomerProducer deleteCustomerProducer, UpdateCustomerProducer updateCustomerProducer, IndividualCustomerBusinessRules individualCustomerBusinessRules) {
        this.individualCustomerRepository = individualCustomerRepository;
        this.createCustomerProducer = createCustomerProducer;
        this.deleteCustomerProducer = deleteCustomerProducer;
        this.updateCustomerProducer = updateCustomerProducer;
        this.individualCustomerBusinessRules = individualCustomerBusinessRules;
    }


    @Override
    public CreatedIndividualCustomerResponse add(CreateIndividualCustomerRequest request) {
        individualCustomerBusinessRules.checkIfIndividualCustomerExistsByIdentityNumber(request.getNatId());
        IndividualCustomer individualCustomer = IndividualCustomerMapper.INSTANCE.individualCustomerFromCreateIndividualCustomerRequest(request);
        IndividualCustomer result = individualCustomerRepository.save(individualCustomer);
        CreateCustomerEvent event = IndividualCustomerMapper.INSTANCE.createCustomerEventFromIndividualCustomer(result);
        createCustomerProducer.produceCustomerCreated(event);

        CreatedIndividualCustomerResponse response = IndividualCustomerMapper.INSTANCE.createdIndividualCustomerResponseFromIndividualCustomer(result);
        return response;
    }

    @Override
    public List<GetListIndividualCustomerResponse> getList() {
        List<IndividualCustomer> individualCustomers = individualCustomerRepository.findAll();
        return IndividualCustomerMapper.INSTANCE.getListIndividualCustomerResponseFromCustomer(individualCustomers);
    }

    @Override
    public void delete(UUID id) {
        IndividualCustomer individualCustomer = individualCustomerRepository.findById(id).orElseThrow(() -> new RuntimeException("Individual Customer with id " + id + " not found"));
        DeleteCustomerEvent event = new DeleteCustomerEvent(
                individualCustomer.getId().toString()
        );
        deleteCustomerProducer.produceCustomerDeleted(event);
        individualCustomer.setDeletedDate(LocalDateTime.now());
        individualCustomerRepository.save(individualCustomer);
    }

    @Override
    public UpdatedIndividualCustomerResponse update(UUID id, UpdateIndividualCustomerRequest request) {
        IndividualCustomer individualCustomer = individualCustomerRepository.findById(id).orElseThrow(() -> new RuntimeException("Individual Customer with id " + id + " not found"));
        individualCustomerBusinessRules.checkIfIndividualCustomerExistsByIdentityNumberExceptCurrent(request.getNatId(),id);
        IndividualCustomerMapper.INSTANCE.individualCustomerFromUpdateIndividualCustomerRequest(request, individualCustomer);
        IndividualCustomer result = individualCustomerRepository.save(individualCustomer);
        UpdateCustomerEvent event = IndividualCustomerMapper.INSTANCE.updateCustomerEventFromIndividualCustomer(result);
        updateCustomerProducer.produceCustomerUpdated(event);
        individualCustomer.setUpdatedDate(LocalDateTime.now());
        UpdatedIndividualCustomerResponse response = IndividualCustomerMapper.INSTANCE.updatedIndividualCustomerResponseFromIndividualCustomer(result);
        return response;
    }
}
