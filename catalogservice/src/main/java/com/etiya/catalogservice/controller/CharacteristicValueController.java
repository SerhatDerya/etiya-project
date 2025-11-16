package com.etiya.catalogservice.controller;

import com.etiya.catalogservice.service.abstracts.CharacteristicValueService;
import com.etiya.catalogservice.service.requests.CreateCharacteristicValueRequest;
import com.etiya.catalogservice.service.responses.characteristicValue.CreatedCharacteristicValueResponse;
import com.etiya.catalogservice.service.responses.characteristicValue.GetListCharacteristicValueResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/characteristic_values/")
public class CharacteristicValueController {
    private final CharacteristicValueService characteristicValueService;

    public CharacteristicValueController(CharacteristicValueService characteristicValueService) {
        this.characteristicValueService = characteristicValueService;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedCharacteristicValueResponse add(@Valid @RequestBody CreateCharacteristicValueRequest request) {
        return characteristicValueService.add(request);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetListCharacteristicValueResponse> getList() {
        return characteristicValueService.getList();
    }
}
