package com.etiya.catalogservice.service.concretes;

import com.etiya.catalogservice.domain.entities.Characteristic;
import com.etiya.catalogservice.repository.CharacteristicRepository;
import com.etiya.catalogservice.service.abstracts.CharacteristicService;
import com.etiya.catalogservice.service.mappings.CharacteristicMapper;
import com.etiya.catalogservice.service.requests.CreateCharacteristicRequest;
import com.etiya.catalogservice.service.responses.characteristic.CreatedCharacteristicResponse;
import com.etiya.catalogservice.service.responses.characteristic.GetListCharacteristicResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacteristicServiceImpl implements CharacteristicService {
    private final CharacteristicRepository characteristicRepository;

    public CharacteristicServiceImpl(CharacteristicRepository characteristicRepository) {
        this.characteristicRepository = characteristicRepository;
    }

    @Override
    public CreatedCharacteristicResponse add(CreateCharacteristicRequest request) {
        Characteristic characteristic = CharacteristicMapper.INSTANCE.characteristicFromCreateCharacteristicRequest(request);
        Characteristic result = characteristicRepository.save(characteristic);
        CreatedCharacteristicResponse response = CharacteristicMapper.INSTANCE.createdCharacteristicResponseFromCharacteristic(result);
        return response;
    }

    @Override
    public List<GetListCharacteristicResponse> getList() {
        List<Characteristic> characteristics = characteristicRepository.findAll();
        return CharacteristicMapper.INSTANCE.getListCharacteristicResponseFromCharacteristic(characteristics);
    }
}
