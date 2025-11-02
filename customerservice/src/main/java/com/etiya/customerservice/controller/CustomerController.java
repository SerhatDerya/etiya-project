package com.etiya.customerservice.controller;

import com.etiya.customerservice.service.abstracts.customer.CustomerService;
import com.etiya.customerservice.service.requests.customer.CreateCustomerRequest;
import com.etiya.customerservice.service.responses.customer.CreatedCustomerResponse;
import com.etiya.customerservice.service.responses.customer.GetListCustomerResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers/")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedCustomerResponse add(@Valid @RequestBody CreateCustomerRequest createCustomerRequest){
        return customerService.add(createCustomerRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetListCustomerResponse> getList(){
        return customerService.getList();
    }
}
