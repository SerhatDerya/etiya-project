package com.etiya.customerservice.service.mappings;

import com.etiya.common.events.billingAccount.CreateBillingAccountEvent;
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
    @Mapping(target = "status.id",source = "statusId")
    @Mapping(target = "type.id",source = "typeId")
    BillingAccount billingAccountFromCreateBillingAccountRequest(CreateBillingAccountRequest request);

    @Mapping(target = "customerId", source = "customer.id")
    @Mapping(target = "addressId", source = "address.id")
    @Mapping(target = "statusId",source = "status.id")
    @Mapping(target = "typeId",source = "type.id")
    @Mapping(target = "statusName",source = "status.name")
    @Mapping(target = "typeName",source = "type.name")
    CreatedBillingAccountResponse createdBillingAccountResponseFromBillingAccount(BillingAccount billingAccount);

    @Mapping(target = "customerId", source = "customer.id")
    @Mapping(target = "addressId", source = "address.id")
    @Mapping(target = "statusId",source = "status.id")
    @Mapping(target = "typeId",source = "type.id")
    @Mapping(target = "statusName",source = "status.name")
    @Mapping(target = "typeName",source = "type.name")
    GetListBillingAccountResponse getListBillingAccountResponseFromBillingAccount(BillingAccount billingAccounts);
    List<GetListBillingAccountResponse>  getListBillingAccountResponseFromBillingAccount(List<BillingAccount> billingAccounts);

    @Mapping(target = "customerId", source = "customer.id")
    @Mapping(target = "addressId", source = "address.id")
    @Mapping(target = "statusId",source = "status.id")
    @Mapping(target = "typeId",source = "type.id")
    @Mapping(target = "typeName",source = "type.name")
    @Mapping(target = "statusName",source = "status.name")
    CreateBillingAccountEvent createBillingAccountEventFromBillingAccount(BillingAccount billingAccount);


}
