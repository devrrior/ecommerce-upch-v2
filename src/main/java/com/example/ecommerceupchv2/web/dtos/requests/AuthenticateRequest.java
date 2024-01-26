package com.example.ecommerceupchv2.web.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class AuthenticateRequest {
    @NotBlank
    private String email;

    @NotBlank
    private String password;
}
