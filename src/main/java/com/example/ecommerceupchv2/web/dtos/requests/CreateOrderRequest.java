package com.example.ecommerceupchv2.web.dtos.requests;

import com.example.ecommerceupchv2.entities.User;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateOrderRequest {
    @NotBlank
    private Long id;

    @NotBlank
    private String status;

    @NotBlank
    private User user;
}
