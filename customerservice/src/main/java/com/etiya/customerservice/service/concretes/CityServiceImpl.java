package com.etiya.customerservice.service.concretes;

import com.etiya.customerservice.domain.entities.City;
import com.etiya.customerservice.repository.CityRepository;
import com.etiya.customerservice.service.abstracts.CityService;
import com.etiya.customerservice.service.mappings.CityMapper;
import com.etiya.customerservice.service.requests.city.CreateCityRequest;
import com.etiya.customerservice.service.responses.city.CreatedCityResponse;
import com.etiya.customerservice.service.responses.city.GetListCityResponse;
import com.etiya.customerservice.service.rules.CityBusinessRules;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;
    private final CityBusinessRules  cityBusinessRules;

    public CityServiceImpl(CityRepository cityRepository, CityBusinessRules cityBusinessRules) {
        this.cityRepository = cityRepository;
        this.cityBusinessRules = cityBusinessRules;
    }

    @Override
    public CreatedCityResponse add(CreateCityRequest request) {
        cityBusinessRules.checkCityExistsName(request.getName());
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
