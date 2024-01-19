package com.example.ecommerceupchv2.web.dtos.requests;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CreateUserRequest {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
}
