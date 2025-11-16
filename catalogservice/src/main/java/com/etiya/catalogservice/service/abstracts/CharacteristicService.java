package com.etiya.catalogservice.service.abstracts;

import com.etiya.catalogservice.domain.entities.Characteristic;
import com.etiya.catalogservice.service.requests.CreateCharacteristicRequest;
import com.etiya.catalogservice.service.responses.characteristic.CreatedCharacteristicResponse;
import com.etiya.catalogservice.service.responses.characteristic.GetListCharacteristicResponse;

import java.util.List;

public interface CharacteristicService {
    CreatedCharacteristicResponse add(CreateCharacteristicRequest request);
    List<GetListCharacteristicResponse> getList();

}
