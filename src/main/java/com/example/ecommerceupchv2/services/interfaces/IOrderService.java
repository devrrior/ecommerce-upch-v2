package com.example.ecommerceupchv2.services.interfaces;

import com.example.ecommerceupchv2.controllers.dtos.requests.CreateOrderRequest;
import com.example.ecommerceupchv2.controllers.dtos.requests.UpdateOrderRequest;
import com.example.ecommerceupchv2.controllers.dtos.responses.BaseResponse;
import com.example.ecommerceupchv2.entities.Order;

public interface IOrderService {
    BaseResponse create(CreateOrderRequest request);
    BaseResponse get(Long id);
    BaseResponse update(Long id, UpdateOrderRequest request);
    BaseResponse delete(Long id);

    Order findByStatus(String Status);
}
