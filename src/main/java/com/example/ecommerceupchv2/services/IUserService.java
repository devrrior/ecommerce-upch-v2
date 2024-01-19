package com.example.ecommerceupchv2.services;

import com.example.ecommerceupchv2.web.dtos.requests.CreateUserRequest;
import com.example.ecommerceupchv2.web.dtos.requests.UpdateUserRequest;
import com.example.ecommerceupchv2.web.dtos.responses.BaseResponse;

public interface IUserService {
    BaseResponse create(CreateUserRequest createUserRequest);
}
