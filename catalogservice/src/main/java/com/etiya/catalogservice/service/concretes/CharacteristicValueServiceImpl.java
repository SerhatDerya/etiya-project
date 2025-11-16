package com.etiya.catalogservice.service.concretes;

import com.etiya.catalogservice.domain.entities.CharacteristicValue;
import com.etiya.catalogservice.repository.CharacteristicValueRepository;
import com.etiya.catalogservice.service.abstracts.CharacteristicValueService;
import com.etiya.catalogservice.service.mappings.CharacteristicValueMapper;
import com.etiya.catalogservice.service.requests.CreateCharacteristicValueRequest;
import com.etiya.catalogservice.service.responses.characteristicValue.CreatedCharacteristicValueResponse;
import com.etiya.catalogservice.service.responses.characteristicValue.GetListCharacteristicValueResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacteristicValueServiceImpl implements CharacteristicValueService {
    private final CharacteristicValueRepository characteristicValueRepository;

    public CharacteristicValueServiceImpl(CharacteristicValueRepository characteristicValueRepository) {
        this.characteristicValueRepository = characteristicValueRepository;
    }

    @Override
    public CreatedCharacteristicValueResponse add(CreateCharacteristicValueRequest request) {
        CharacteristicValue characteristicValue = CharacteristicValueMapper.INSTANCE.characteristicValueFromCreateCharacteristicValueRequest(request);
        CharacteristicValue result = characteristicValueRepository.save(characteristicValue);
        CreatedCharacteristicValueResponse response = CharacteristicValueMapper.INSTANCE.createdCharacteristicValueResponseFromCharacteristicValue(result);
        return response;
    }

    @Override
    public List<GetListCharacteristicValueResponse> getList() {
        List<CharacteristicValue> characteristicValues = characteristicValueRepository.findAll();
        return CharacteristicValueMapper.INSTANCE.getListCharacteristicValueFromCharacteristicValue(characteristicValues);
    }
}
