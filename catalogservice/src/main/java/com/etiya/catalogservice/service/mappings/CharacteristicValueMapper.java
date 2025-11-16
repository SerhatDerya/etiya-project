package com.etiya.catalogservice.service.mappings;

import com.etiya.catalogservice.domain.entities.CharacteristicValue;
import com.etiya.catalogservice.service.requests.CreateCharacteristicValueRequest;
import com.etiya.catalogservice.service.responses.characteristicValue.CreatedCharacteristicValueResponse;
import com.etiya.catalogservice.service.responses.characteristicValue.GetListCharacteristicValueResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CharacteristicValueMapper {
    CharacteristicValueMapper INSTANCE = Mappers.getMapper(CharacteristicValueMapper.class);

    @Mapping(target = "characteristic.id",source = "charId")
    CharacteristicValue characteristicValueFromCreateCharacteristicValueRequest(CreateCharacteristicValueRequest request);

    @Mapping(target = "charId",source = "characteristic.id")
    CreatedCharacteristicValueResponse  createdCharacteristicValueResponseFromCharacteristicValue(CharacteristicValue characteristicValue);

    @Mapping(target = "charId",source = "characteristic.id")
    GetListCharacteristicValueResponse getListCharacteristicValueFromCharacteristicValue(CharacteristicValue characteristicValues);
    List<GetListCharacteristicValueResponse> getListCharacteristicValueFromCharacteristicValue(List<CharacteristicValue> characteristicValues);
}
