package com.example.ecommerceupchv2.services.interfaces;

import com.example.ecommerceupchv2.controllers.dtos.requests.CreateUserRequest;
import com.example.ecommerceupchv2.controllers.dtos.requests.UpdateUserRequest;
import com.example.ecommerceupchv2.controllers.dtos.responses.BaseResponse;

public interface IUserService {
    BaseResponse create(CreateUserRequest request);
    BaseResponse get(Long id);
    BaseResponse update(Long id, UpdateUserRequest request);
    BaseResponse delete(Long id);
}
