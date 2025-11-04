package com.etiya.customerservice.service.mappings.city;


import com.etiya.customerservice.domain.entities.City;
import com.etiya.customerservice.service.requests.city.CreateCityRequest;
import com.etiya.customerservice.service.responses.city.CreatedCityResponse;
import com.etiya.customerservice.service.responses.city.GetListCityResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CityMapper {

    CityMapper INSTANCE = Mappers.getMapper(CityMapper.class);

    City cityFromCreateCityRequest(CreateCityRequest request);

    CreatedCityResponse createdCityResponseFromCity(City city);

    List<GetListCityResponse> getListCityResponseFromCity(List<City> city);
}
