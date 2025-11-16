package com.etiya.catalogservice.service.abstracts;

import com.etiya.catalogservice.service.requests.CreateCharacteristicValueRequest;
import com.etiya.catalogservice.service.responses.characteristicValue.CreatedCharacteristicValueResponse;
import com.etiya.catalogservice.service.responses.characteristicValue.GetListCharacteristicValueResponse;

import java.util.List;

public interface CharacteristicValueService {
    CreatedCharacteristicValueResponse add(CreateCharacteristicValueRequest request);
    List<GetListCharacteristicValueResponse> getList();
}
