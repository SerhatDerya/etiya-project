package com.etiya.customerservice.service.requests.accountStatus;


import com.etiya.common.validations.Status;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateStatusRequest {

    @NotBlank(message = "Status cannot be empty")
    @Status
    private String name;
}
