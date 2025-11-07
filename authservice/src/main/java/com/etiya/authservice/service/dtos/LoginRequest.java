package com.etiya.authservice.service.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
    @NotBlank(message = "User name cannot be empty")
    private String username;
    @NotBlank(message = "Password cannot be empty")
    private String password;
}
