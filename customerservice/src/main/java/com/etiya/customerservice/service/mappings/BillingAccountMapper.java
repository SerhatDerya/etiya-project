package com.etiya.customerservice.service.mappings;

import com.etiya.common.events.billingAccount.CreateBillingAccountEvent;
import com.etiya.common.events.billingAccount.UpdateBillingAccountEvent;
import com.etiya.common.responses.BillingAccountResponse;
import com.etiya.customerservice.domain.entities.BillingAccount;
import com.etiya.customerservice.service.requests.billingAccount.CreateBillingAccountRequest;
import com.etiya.customerservice.service.requests.billingAccount.UpdateBillingAccountRequest;
import com.etiya.customerservice.service.responses.billingAccount.CreatedBillingAccountResponse;
import com.etiya.customerservice.service.responses.billingAccount.GetListBillingAccountResponse;
import com.etiya.customerservice.service.responses.billingAccount.UpdatedBillingAccountResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
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

    @Mapping(target = "customer.id",source = "customerId")
//    @Mapping(target = "address.id",source = "addressId")
    @Mapping(target = "address", ignore = true)
    void billingAccountFromUpdateBillingAccountRequest(UpdateBillingAccountRequest request, @MappingTarget BillingAccount billingAccount);

    @Mapping(target = "customerId", source = "customer.id")
    @Mapping(target = "addressId", source = "address.id")
    @Mapping(target = "statusId",source = "status.id")
    @Mapping(target = "typeId",source = "type.id")
    @Mapping(target = "statusName",source = "status.name")
    @Mapping(target = "typeName",source = "type.name")
    UpdatedBillingAccountResponse updatedBillingAccountResponseFromBillingAccount(BillingAccount billingAccount);

    @Mapping(target = "customerId", source = "customer.id")
    @Mapping(target = "addressId", source = "address.id")
    @Mapping(target = "statusId",source = "status.id")
    @Mapping(target = "typeId",source = "type.id")
    @Mapping(target = "statusName",source = "status.name")
    @Mapping(target = "typeName",source = "type.name")
    UpdateBillingAccountEvent updateBillingAccountEventFromBillingAccount(BillingAccount billingAccount);

    BillingAccountResponse billingAccountResponseFromBillingAccount(BillingAccount billingAccount);


}
