package com.etiya.customerservice.controller;

import com.etiya.customerservice.service.abstracts.CityService;
import com.etiya.customerservice.service.requests.city.CreateCityRequest;
import com.etiya.customerservice.service.responses.city.CreatedCityResponse;
import com.etiya.customerservice.service.responses.city.GetListCityResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cities/")
public class CityController {
    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedCityResponse add(@Valid @RequestBody CreateCityRequest request){
        return cityService.add(request);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetListCityResponse> getList(){
        return cityService.getList();
    }
}
