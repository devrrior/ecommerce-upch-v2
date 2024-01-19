package com.example.ecommerceupchv2.web.dtos.responses;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class GetUserResponse {
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
}
