package com.etiya.customerservice.service.abstracts;


import com.etiya.customerservice.service.requests.contactMedium.CreateContactMediumRequest;
import com.etiya.customerservice.service.requests.contactMedium.UpdateContactMediumRequest;
import com.etiya.customerservice.service.responses.contactMedium.CreatedContactMediumResponse;
import com.etiya.customerservice.service.responses.contactMedium.GetListContactMediumResponse;
import com.etiya.customerservice.service.responses.contactMedium.UpdatedContactMediumResponse;


import java.util.List;
import java.util.UUID;

public interface ContactMediumService {
    CreatedContactMediumResponse add(CreateContactMediumRequest request);
    List<GetListContactMediumResponse> getList();
    UpdatedContactMediumResponse update(UUID id, UpdateContactMediumRequest request);
    void delete(UUID id);
}
