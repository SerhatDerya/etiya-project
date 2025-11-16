package com.etiya.catalogservice.controller;

import com.etiya.catalogservice.service.abstracts.CharacteristicService;
import com.etiya.catalogservice.service.requests.CreateCharacteristicRequest;
import com.etiya.catalogservice.service.responses.characteristic.CreatedCharacteristicResponse;
import com.etiya.catalogservice.service.responses.characteristic.GetListCharacteristicResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/characteristics/")
public class CharacteristicController {
    private final CharacteristicService characteristicService;

    public CharacteristicController(CharacteristicService characteristicService) {
        this.characteristicService = characteristicService;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedCharacteristicResponse add(@Valid @RequestBody CreateCharacteristicRequest request) {
        return characteristicService.add(request);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetListCharacteristicResponse> getList() {
        return characteristicService.getList();
    }
}
