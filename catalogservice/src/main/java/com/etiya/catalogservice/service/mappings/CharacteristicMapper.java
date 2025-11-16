package com.etiya.catalogservice.service.mappings;

import com.etiya.catalogservice.domain.entities.Characteristic;
import com.etiya.catalogservice.service.requests.CreateCharacteristicRequest;
import com.etiya.catalogservice.service.responses.characteristic.CreatedCharacteristicResponse;
import com.etiya.catalogservice.service.responses.characteristic.GetListCharacteristicResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CharacteristicMapper {
    CharacteristicMapper INSTANCE = Mappers.getMapper(CharacteristicMapper.class);

    Characteristic characteristicFromCreateCharacteristicRequest(CreateCharacteristicRequest request);

    CreatedCharacteristicResponse createdCharacteristicResponseFromCharacteristic(Characteristic characteristic);



    List<GetListCharacteristicResponse>  getListCharacteristicResponseFromCharacteristic(List<Characteristic> characteristics);
}
