package com.etiya.customerservice.service.abstracts;

import com.etiya.customerservice.service.requests.accountType.CreateTypeRequest;
import com.etiya.customerservice.service.responses.accountType.CreatedTypeResponse;
import com.etiya.customerservice.service.responses.accountType.GetListTypeResponse;

import java.util.List;

public interface TypeService {
    CreatedTypeResponse add(CreateTypeRequest request);
    List<GetListTypeResponse> getList();
}
