package com.etiya.customerservice.service.concretes.customer;

import com.etiya.common.events.CreateCustomerEvent;
import com.etiya.customerservice.domain.entities.Customer;
import com.etiya.customerservice.repository.CustomerRepository;
import com.etiya.customerservice.service.rules.customer.CustomerBusinessRules;
import com.etiya.customerservice.service.abstracts.customer.CustomerService;
import com.etiya.customerservice.service.mappings.customer.CustomerMapper;
import com.etiya.customerservice.service.requests.customer.CreateCustomerRequest;
import com.etiya.customerservice.service.responses.customer.CreatedCustomerResponse;
import com.etiya.customerservice.service.responses.customer.GetListCustomerResponse;
import com.etiya.customerservice.transport.kafka.producer.customer.CreateCustomerProducer;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CreateCustomerProducer createCustomerProducer;
    private final CustomerBusinessRules customerBusinessRules;

    public CustomerServiceImpl(CustomerRepository customerRepository, CreateCustomerProducer createCustomerProducer, CustomerBusinessRules customerBusinessRules) {
        this.customerRepository = customerRepository;
        this.createCustomerProducer = createCustomerProducer;
        this.customerBusinessRules = customerBusinessRules;
    }


    @Override
    public CreatedCustomerResponse add(CreateCustomerRequest request) {
        customerBusinessRules.checkIfCustomerExistsByIdentityNumber(request.getNatId());
        Customer customer = CustomerMapper.INSTANCE.customerFromCreateCustomerRequest(request);
        Customer createdCustomer = customerRepository.save(customer);
        CreateCustomerEvent event = CustomerMapper.INSTANCE.createCustomerEventFromCustomer(createdCustomer);
        createCustomerProducer.produceCustomerCreated(event);

        CreatedCustomerResponse response = CustomerMapper.INSTANCE.createdCustomerResponseFromCustomer(createdCustomer);
        return response;
    }

    @Override
    public List<GetListCustomerResponse> getList() {
        List<Customer> customers = customerRepository.findAll();
        return CustomerMapper.INSTANCE.getListCustomerResponseFromCustomer(customers);
    }
}
