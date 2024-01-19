package com.example.ecommerceupchv2.controllers;

import com.example.ecommerceupchv2.controllers.dtos.requests.CreateOrderRequest;
import com.example.ecommerceupchv2.controllers.dtos.requests.UpdateOrderRequest;
import com.example.ecommerceupchv2.controllers.dtos.responses.BaseResponse;
import com.example.ecommerceupchv2.services.interfaces.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("order")
@RestController
public class OrderController {
    @Autowired
    private IOrderService service;

    @GetMapping("{id}")
    public ResponseEntity<BaseResponse> get(@PathVariable Long Id){
        BaseResponse response = service.get(Id);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }

    @PostMapping
    public ResponseEntity<BaseResponse> create(@RequestBody CreateOrderRequest request){
        BaseResponse response = service.create(request);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }

    @PutMapping("{id}")
    public ResponseEntity<BaseResponse> update(@RequestBody UpdateOrderRequest request, @PathVariable Long Id){
        BaseResponse response = service.update(Id, request);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<BaseResponse> delete(@PathVariable Long Id){
        BaseResponse response = service.delete(Id);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }
}
