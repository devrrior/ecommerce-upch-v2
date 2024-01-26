package com.example.ecommerceupchv2.services;

import com.example.ecommerceupchv2.web.dtos.requests.AuthenticateRequest;
import com.example.ecommerceupchv2.web.dtos.responses.BaseResponse;

public interface IAuthService {
    BaseResponse authenticate(AuthenticateRequest request);
}
