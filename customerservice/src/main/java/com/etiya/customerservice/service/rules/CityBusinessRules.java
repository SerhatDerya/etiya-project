package com.etiya.customerservice.service.rules;

import com.etiya.common.crosscuttingconcerns.exceptions.types.BusinessException;
import com.etiya.common.localization.LocalizationService;
import com.etiya.customerservice.domain.entities.Address;
import com.etiya.customerservice.domain.entities.City;
import com.etiya.customerservice.repository.CityRepository;
import com.etiya.customerservice.service.messages.Messages;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.UUID;

@Service
public class CityBusinessRules {
    private final CityRepository cityRepository;
    private final LocalizationService localizationService;

    public CityBusinessRules(CityRepository cityRepository, LocalizationService localizationService) {
        this.cityRepository = cityRepository;
        this.localizationService = localizationService;
    }

    public City getCityIfExists(Integer id) {
        return cityRepository.findById(id)
                .orElseThrow(() -> new BusinessException(localizationService.getMessage(Messages.CityNotFound)));
    }
    public void checkCityExistsName(String name){
        if(cityRepository.existsByNameIgnoreCase(name)){
            throw new BusinessException(localizationService.getMessage(Messages.CityExistsName));
        }
    }
}
