package com.etiya.customerservice.service.mappings;


import com.etiya.customerservice.domain.entities.Status;
import com.etiya.customerservice.service.requests.accountStatus.CreateStatusRequest;
import com.etiya.customerservice.service.responses.accountStatus.CreatedStatusResponse;
import com.etiya.customerservice.service.responses.accountStatus.GetListStatusResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface StatusMapper {

    StatusMapper INSTANCE = Mappers.getMapper(StatusMapper.class);


    Status statusFromCreateStatusRequest (CreateStatusRequest request);


    CreatedStatusResponse createdStatusResponseFromStatus(Status status);


    GetListStatusResponse getListStatusResponseFromStatus(Status statuses);
    List<GetListStatusResponse> getListStatusResponseFromStatus(List<Status> statuses);




}
