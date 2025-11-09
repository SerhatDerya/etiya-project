package com.etiya.customerservice.controller;


import com.etiya.customerservice.service.abstracts.ContactMediumService;
import com.etiya.customerservice.service.requests.contactMedium.CreateContactMediumRequest;
import com.etiya.customerservice.service.requests.contactMedium.UpdateContactMediumRequest;
import com.etiya.customerservice.service.responses.contactMedium.CreatedContactMediumResponse;
import com.etiya.customerservice.service.responses.contactMedium.GetListContactMediumResponse;
import com.etiya.customerservice.service.responses.contactMedium.UpdatedContactMediumResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/contact-mediums/")
public class ContactMediumController {
    private final ContactMediumService contactMediumService;

    public ContactMediumController(ContactMediumService contactMediumService) {
        this.contactMediumService = contactMediumService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedContactMediumResponse add(@Valid @RequestBody CreateContactMediumRequest request) {
        return contactMediumService.add(request);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetListContactMediumResponse> getList() {
        return contactMediumService.getList();
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public UpdatedContactMediumResponse update(@Valid @PathVariable UUID id, @RequestBody UpdateContactMediumRequest request) {
        return contactMediumService.update(id,request);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable UUID id) {
        contactMediumService.delete(id);
    }


}
