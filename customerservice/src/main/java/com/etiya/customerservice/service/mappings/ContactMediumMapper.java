package com.etiya.customerservice.service.mappings;


import com.etiya.common.events.CreateContactMediumEvent;
import com.etiya.customerservice.domain.entities.ContactMedium;
import com.etiya.customerservice.service.requests.contactMedium.CreateContactMediumRequest;
import com.etiya.customerservice.service.responses.contactMedium.CreatedContactMediumResponse;
import com.etiya.customerservice.service.responses.contactMedium.GetListContactMediumReponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ContactMediumMapper {


    ContactMediumMapper INSTANCE = Mappers.getMapper(ContactMediumMapper.class);

    @Mapping(target = "customer.id", source = "customerId")
    ContactMedium contactMediumFromCreateContactMediumRequest(CreateContactMediumRequest request);

    @Mapping(target = "customerId", source = "customer.id")
    CreatedContactMediumResponse createdContactMediumResponseFromContactMedium(ContactMedium contactMedium);

    @Mapping(target = "customerId", source = "customer.id")
    GetListContactMediumReponse getListContactMediumResponseFromContactMedium(ContactMedium contactMedium);
    List<GetListContactMediumReponse>  getListContactMediumResponseFromContactMedium(List<ContactMedium> contactMediums);

    @Mapping(target = "customerId", source = "customer.id")
    CreateContactMediumEvent createContactMediumEventFromContactMedium(ContactMedium contactMedium);
}
