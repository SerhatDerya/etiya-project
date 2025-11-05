package com.etiya.customerservice.service.concretes;

import com.etiya.common.events.CreateCustomerEvent;
import com.etiya.customerservice.domain.entities.IndividualCustomer;
import com.etiya.customerservice.repository.IndividualCustomerRepository;
import com.etiya.customerservice.service.rules.customer.IndividualCustomerBusinessRules;
import com.etiya.customerservice.service.abstracts.IndividualCustomerService;
import com.etiya.customerservice.service.mappings.IndividualCustomerMapper;
import com.etiya.customerservice.service.requests.customer.CreateIndividualCustomerRequest;
import com.etiya.customerservice.service.responses.customer.CreatedIndividualCustomerResponse;
import com.etiya.customerservice.service.responses.customer.GetListIndividualCustomerResponse;
import com.etiya.customerservice.transport.kafka.producer.customer.CreateCustomerProducer;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class IndividualCustomerServiceImpl implements IndividualCustomerService {
    private final IndividualCustomerRepository individualCustomerRepository;
    private final CreateCustomerProducer createCustomerProducer;
    private final IndividualCustomerBusinessRules individualCustomerBusinessRules;

    public IndividualCustomerServiceImpl(IndividualCustomerRepository individualCustomerRepository, CreateCustomerProducer createCustomerProducer, IndividualCustomerBusinessRules individualCustomerBusinessRules) {
        this.individualCustomerRepository = individualCustomerRepository;
        this.createCustomerProducer = createCustomerProducer;
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
}
