package com.etiya.customerservice.service.abstracts.city;

import com.etiya.customerservice.service.requests.city.CreateCityRequest;
import com.etiya.customerservice.service.responses.city.CreatedCityResponse;
import com.etiya.customerservice.service.responses.city.GetListCityResponse;

import java.util.List;

public interface CityService {
    CreatedCityResponse add(CreateCityRequest request);
    List<GetListCityResponse> getList();
}
