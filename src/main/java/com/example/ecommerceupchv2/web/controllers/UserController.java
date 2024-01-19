package com.example.ecommerceupchv2.web.controllers;

import com.example.ecommerceupchv2.web.dtos.requests.CreateUserRequest;
import com.example.ecommerceupchv2.web.dtos.requests.UpdateUserRequest;
import com.example.ecommerceupchv2.web.dtos.responses.BaseResponse;
import com.example.ecommerceupchv2.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private IUserService service;

    @GetMapping("{id}")
    public ResponseEntity<BaseResponse> get(@PathVariable Long id){
        BaseResponse response = service.get(id);
        return new ResponseEntity<>(response, response.getStatus());
    }

    @PostMapping
    public ResponseEntity<BaseResponse> create(@RequestBody CreateUserRequest request) {
        BaseResponse response = service.create(request);
        return new ResponseEntity<>(response, response.getStatus());
    }

    @PutMapping("{id}")
    public ResponseEntity<BaseResponse> update(@PathVariable Long id, @RequestBody UpdateUserRequest request){
        BaseResponse response = service.update(id, request);
        return new ResponseEntity<>(response, response.getStatus());
    }

    @DeleteMapping("{id}")
        public ResponseEntity<BaseResponse> delete(@PathVariable Long id) {
            BaseResponse response = service.delete(id);
            return new ResponseEntity<>(response, response.getStatus());
        }

}
