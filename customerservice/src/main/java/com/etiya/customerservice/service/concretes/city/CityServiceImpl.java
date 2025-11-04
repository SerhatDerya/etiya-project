package com.etiya.customerservice.service.concretes.city;

import com.etiya.customerservice.domain.entities.City;
import com.etiya.customerservice.repository.CityRepository;
import com.etiya.customerservice.service.abstracts.city.CityService;
import com.etiya.customerservice.service.mappings.city.CityMapper;
import com.etiya.customerservice.service.requests.city.CreateCityRequest;
import com.etiya.customerservice.service.responses.city.CreatedCityResponse;
import com.etiya.customerservice.service.responses.city.GetListCityResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public CreatedCityResponse add(CreateCityRequest request) {
        City city = CityMapper.INSTANCE.cityFromCreateCityRequest(request);
        City result = cityRepository.save(city);
        CreatedCityResponse response = CityMapper.INSTANCE.createdCityResponseFromCity(result);
        return response;
    }

    @Override
    public List<GetListCityResponse> getList() {
        List<City> cities = cityRepository.findAll();
        return CityMapper.INSTANCE.getListCityResponseFromCity(cities);
    }
}
