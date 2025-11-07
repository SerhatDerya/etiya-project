package com.etiya.customerservice.controller;

import com.etiya.customerservice.service.abstracts.TypeService;
import com.etiya.customerservice.service.requests.accountType.CreateTypeRequest;
import com.etiya.customerservice.service.responses.accountType.CreatedTypeResponse;
import com.etiya.customerservice.service.responses.accountType.GetListTypeResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/types/")
public class TypeController {

    private final TypeService typeService;

    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedTypeResponse add(@Valid @RequestBody CreateTypeRequest request) {
        return typeService.add(request);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetListTypeResponse> getList(){
        return typeService.getList();
    }
}
