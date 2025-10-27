package com.etiya.customerservice.service.concretes;

import com.etiya.common.events.CreateCustomerEvent;
import com.etiya.customerservice.domain.entities.Customer;
import com.etiya.customerservice.repository.CustomerRepository;
import com.etiya.customerservice.service.abstracts.CustomerService;
import com.etiya.customerservice.service.mappings.CustomerMapper;
import com.etiya.customerservice.service.requests.customers.CreateCustomerRequest;
import com.etiya.customerservice.service.responses.individualcustomers.CreatedCustomerResponse;
import com.etiya.customerservice.service.responses.individualcustomers.GetListCustomerResponse;
import com.etiya.customerservice.transport.kafka.producer.customer.CreateCustomerProducer;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CreateCustomerProducer createCustomerProducer;

    public CustomerServiceImpl(CustomerRepository customerRepository, CreateCustomerProducer createCustomerProducer) {
        this.customerRepository = customerRepository;
        this.createCustomerProducer = createCustomerProducer;
    }


    @Override
    public CreatedCustomerResponse add(CreateCustomerRequest request) {
        System.out.println("request received: " + request.getFirstName());
        Customer customer = CustomerMapper.INSTANCE.createCustomerRequestToCustomer(request);
        System.out.println("Customer: " + customer.getFirstName());
        Customer createdCustomer = customerRepository.save(customer);
        System.out.println("Created Customer: " + createdCustomer.getFirstName());
        CreateCustomerEvent event =
                new CreateCustomerEvent(
                        createdCustomer.getFirstName(),
                        createdCustomer.getMiddleName(),
                        createdCustomer.getLastName(),
                        createdCustomer.getDateOfBirth(),
                        createdCustomer.getGender(),
                        createdCustomer.getMotherName(),
                        createdCustomer.getFatherName(),
                        createdCustomer.getNatId()
                );
        createCustomerProducer.produceCustomerCreated(event);

        CreatedCustomerResponse createdCustomerResponse = CustomerMapper.INSTANCE.customerToCreatedCustomerResponse(createdCustomer);
        System.out.println("Created Customer Response: " + createdCustomerResponse.getFirstName());
        return createdCustomerResponse;
    }

    @Override
    public List<GetListCustomerResponse> getList() {
        List<Customer> customers = customerRepository.findAll();
        return CustomerMapper.INSTANCE.getListCustomerResponseFromCustomer(customers);
    }
}
