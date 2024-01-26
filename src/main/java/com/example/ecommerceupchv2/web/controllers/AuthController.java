package com.example.ecommerceupchv2.web.controllers;

import com.example.ecommerceupchv2.services.IAuthService;
import com.example.ecommerceupchv2.web.dtos.requests.AuthenticateRequest;
import com.example.ecommerceupchv2.web.dtos.responses.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController {

    private final IAuthService authService;

    public AuthController(IAuthService authService) {
        this.authService = authService;
    }


    @PostMapping("authenticate")
    public ResponseEntity<BaseResponse> authenticate(@RequestBody AuthenticateRequest request) {
        BaseResponse response = authService.authenticate(request);

        return response.apply();

    }
}
