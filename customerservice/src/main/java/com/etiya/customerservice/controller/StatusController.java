package com.etiya.customerservice.controller;

import com.etiya.customerservice.service.abstracts.StatusService;
import com.etiya.customerservice.service.requests.accountStatus.CreateStatusRequest;
import com.etiya.customerservice.service.responses.accountStatus.CreatedStatusResponse;
import com.etiya.customerservice.service.responses.accountStatus.GetListStatusResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/statuses/")
public class StatusController {

    private final StatusService statusService;

    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedStatusResponse add(@Valid @RequestBody CreateStatusRequest request) {
        return statusService.add(request);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetListStatusResponse> getList() {
        return statusService.getList();
    }

}
