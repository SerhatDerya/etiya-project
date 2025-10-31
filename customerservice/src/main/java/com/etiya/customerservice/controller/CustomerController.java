package com.etiya.customerservice.controller;

import com.etiya.customerservice.service.abstracts.CustomerService;
import com.etiya.customerservice.service.requests.customers.CreateCustomerRequest;
import com.etiya.customerservice.service.responses.customers.CreatedCustomerResponse;
import com.etiya.customerservice.service.responses.customers.GetListCustomerResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
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
