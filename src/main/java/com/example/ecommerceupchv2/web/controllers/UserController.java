package com.example.ecommerceupchv2.web.controllers;

import com.example.ecommerceupchv2.services.IUserService;
import com.example.ecommerceupchv2.web.dtos.requests.CreateUserRequest;
import com.example.ecommerceupchv2.web.dtos.requests.UpdateUserRequest;
import com.example.ecommerceupchv2.web.dtos.responses.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {
    private final IUserService service;

    public UserController(IUserService service) {
        this.service = service;
    }

    @GetMapping("{id}")
    public ResponseEntity<BaseResponse> get(@PathVariable Long id) {
        BaseResponse response = service.get(id);
        return new ResponseEntity<>(response, response.getStatus());
    }

    @PostMapping
    public ResponseEntity<BaseResponse> create(@RequestBody CreateUserRequest request) {
        BaseResponse response = service.create(request);
        return response.apply();
    }

    @PutMapping("{id}")
    public ResponseEntity<BaseResponse> update(@PathVariable Long id, @RequestBody UpdateUserRequest request){
        BaseResponse response = service.update(id, request);
        return response.apply();
    }

    @DeleteMapping("{id}")
        public ResponseEntity<BaseResponse> delete(@PathVariable Long id) {
            BaseResponse response = service.delete(id);
            return response.apply();
        }

}
