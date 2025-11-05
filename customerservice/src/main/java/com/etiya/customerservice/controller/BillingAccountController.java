package com.etiya.customerservice.controller;

import com.etiya.customerservice.service.abstracts.BillingAccountService;
import com.etiya.customerservice.service.requests.billingAccount.CreateBillingAccountRequest;
import com.etiya.customerservice.service.responses.billingAccount.CreatedBillingAccountResponse;
import com.etiya.customerservice.service.responses.billingAccount.GetListBillingAccountResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/billing-accounts/")
public class BillingAccountController {
    private final BillingAccountService billingAccountService;

    public BillingAccountController(BillingAccountService billingAccountService) {
        this.billingAccountService = billingAccountService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedBillingAccountResponse add(@Valid @RequestBody CreateBillingAccountRequest request){
        return billingAccountService.add(request);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetListBillingAccountResponse> getList(){
        return billingAccountService.getList();
    }
}
