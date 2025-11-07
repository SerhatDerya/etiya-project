package com.etiya.customerservice.service.concretes;

import com.etiya.customerservice.domain.entities.Type;
import com.etiya.customerservice.repository.TypeRepository;
import com.etiya.customerservice.service.abstracts.TypeService;
import com.etiya.customerservice.service.mappings.TypeMapper;
import com.etiya.customerservice.service.requests.accountType.CreateTypeRequest;
import com.etiya.customerservice.service.responses.accountType.CreatedTypeResponse;
import com.etiya.customerservice.service.responses.accountType.GetListTypeResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    private final TypeRepository typeRepository;

    public TypeServiceImpl(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    @Override
    public CreatedTypeResponse add(CreateTypeRequest request) {
        Type type = TypeMapper.INSTANCE.typeFromCreateTypeRequest(request);
        Type result = typeRepository.save(type);
        CreatedTypeResponse response = TypeMapper.INSTANCE.createdTypeResponseFromType(result);
        return response;

//        Type type = new Type();
//        type.setName(request.getName());
//        Type result = typeRepository.save(type);
//        CreatedTypeResponse response = new CreatedTypeResponse();
//        response.setId(result.getId());
//        return response;
    }

    @Override
    public List<GetListTypeResponse> getList() {
        List<Type> types = typeRepository.findAll();
        return TypeMapper.INSTANCE.getListTypeResponseFromType(types);
    }
}
