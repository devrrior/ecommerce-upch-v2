package com.example.ecommerceupchv2.services;

import com.example.ecommerceupchv2.entities.User;
import com.example.ecommerceupchv2.web.dtos.requests.CreateUserRequest;
import com.example.ecommerceupchv2.web.dtos.requests.UpdateUserRequest;
import com.example.ecommerceupchv2.web.dtos.responses.BaseResponse;

public interface IUserService {
    BaseResponse get(Long id);
    BaseResponse create(CreateUserRequest request);
    BaseResponse update(Long id, UpdateUserRequest request);
    BaseResponse delete(Long id);
    User findOneAndEnsureExist(Long id);
    User findOneAndEnsureExist(String email);
}
