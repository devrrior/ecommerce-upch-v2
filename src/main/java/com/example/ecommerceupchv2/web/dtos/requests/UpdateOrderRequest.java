package com.example.ecommerceupchv2.web.dtos.requests;

import com.example.ecommerceupchv2.entities.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateOrderRequest {
    private Long id;
    private String status;
    private User user;
}
