package com.etiya.customerservice.service.abstracts;


import com.etiya.customerservice.service.requests.contactMedium.CreateContactMediumRequest;
import com.etiya.customerservice.service.responses.contactMedium.CreatedContactMediumResponse;
import com.etiya.customerservice.service.responses.contactMedium.GetListContactMediumReponse;


import java.util.List;

public interface ContactMediumService {
    CreatedContactMediumResponse add(CreateContactMediumRequest request);
    List<GetListContactMediumReponse> getList();
}
