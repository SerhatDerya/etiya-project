package com.etiya.customerservice.service.mappings;

import com.etiya.common.events.CreateBillingAccountEvent;
import com.etiya.customerservice.domain.entities.BillingAccount;
import com.etiya.customerservice.service.requests.billingAccount.CreateBillingAccountRequest;
import com.etiya.customerservice.service.responses.billingAccount.CreatedBillingAccountResponse;
import com.etiya.customerservice.service.responses.billingAccount.GetListBillingAccountResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BillingAccountMapper {

    BillingAccountMapper INSTANCE = Mappers.getMapper(BillingAccountMapper.class);

    @Mapping(target = "customer.id",source = "customerId")
    @Mapping(target = "address.id",source = "addressId")
    BillingAccount billingAccountFromCreateBillingAccountRequest(CreateBillingAccountRequest request);

    @Mapping(target = "customerId", source = "customer.id")
    @Mapping(target = "addressId", source = "address.id")
    CreatedBillingAccountResponse createdBillingAccountResponseFromBillingAccount(BillingAccount billingAccount);

    @Mapping(target = "customerId", source = "customer.id")
    @Mapping(target = "addressId", source = "address.id")
    GetListBillingAccountResponse getListBillingAccountResponseFromBillingAccount(BillingAccount billingAccounts);
    List<GetListBillingAccountResponse>  getListBillingAccountResponseFromBillingAccount(List<BillingAccount> billingAccounts);

    @Mapping(target = "customerId", source = "customer.id")
    @Mapping(target = "addressId", source = "address.id")
    CreateBillingAccountEvent createBillingAccountEventFromBillingAccount(BillingAccount billingAccount);
}
