package com.etiya.customerservice.service.abstracts;

import com.etiya.customerservice.service.requests.accountStatus.CreateStatusRequest;
import com.etiya.customerservice.service.responses.accountStatus.CreatedStatusResponse;
import com.etiya.customerservice.service.responses.accountStatus.GetListStatusResponse;

import java.util.List;

public interface StatusService {
    CreatedStatusResponse add(CreateStatusRequest request);
    List<GetListStatusResponse> getList();
}
