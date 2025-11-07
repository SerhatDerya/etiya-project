package com.etiya.customerservice.service.requests.accountType;

import com.etiya.common.validations.Type;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateTypeRequest {

    @NotBlank(message = "Type cannot be empty")
    @Type
    private String name;
}
