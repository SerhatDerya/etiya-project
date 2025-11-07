package com.etiya.customerservice.service.mappings;


import com.etiya.customerservice.domain.entities.Type;
import com.etiya.customerservice.service.requests.accountType.CreateTypeRequest;
import com.etiya.customerservice.service.responses.accountType.CreatedTypeResponse;
import com.etiya.customerservice.service.responses.accountType.GetListTypeResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TypeMapper {

    TypeMapper INSTANCE = Mappers.getMapper(TypeMapper.class);


    Type typeFromCreateTypeRequest (CreateTypeRequest request);

    CreatedTypeResponse createdTypeResponseFromType(Type type);


    GetListTypeResponse getListTypeResponseFromType(Type types);
    List<GetListTypeResponse> getListTypeResponseFromType(List<Type> types);


}
