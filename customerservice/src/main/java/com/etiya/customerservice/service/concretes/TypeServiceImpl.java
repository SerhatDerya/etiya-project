package com.etiya.customerservice.service.concretes;

import com.etiya.customerservice.domain.entities.Type;
import com.etiya.customerservice.repository.TypeRepository;
import com.etiya.customerservice.service.abstracts.TypeService;
import com.etiya.customerservice.service.mappings.TypeMapper;
import com.etiya.customerservice.service.requests.accountType.CreateTypeRequest;
import com.etiya.customerservice.service.responses.accountType.CreatedTypeResponse;
import com.etiya.customerservice.service.responses.accountType.GetListTypeResponse;
import com.etiya.customerservice.service.rules.TypeBusinessRules;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    private final TypeRepository typeRepository;
    private final TypeBusinessRules typeBusinessRules;

    public TypeServiceImpl(TypeRepository typeRepository, TypeBusinessRules typeBusinessRules) {
        this.typeRepository = typeRepository;
        this.typeBusinessRules = typeBusinessRules;
    }

    @Override
    public CreatedTypeResponse add(CreateTypeRequest request) {
        typeBusinessRules.checkTypeExistsName(request.getName());
        Type type = TypeMapper.INSTANCE.typeFromCreateTypeRequest(request);
        Type result = typeRepository.save(type);
        CreatedTypeResponse response = TypeMapper.INSTANCE.createdTypeResponseFromType(result);
        return response;
    }

    @Override
    public List<GetListTypeResponse> getList() {
        List<Type> types = typeRepository.findAll();
        return TypeMapper.INSTANCE.getListTypeResponseFromType(types);
    }
}
