package com.example.ecommerceupchv2.controllers.dtos.requests;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UpdateUserRequest {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
}
