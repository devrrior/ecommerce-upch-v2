package com.example.ecommerceupchv2.web.controllers;

import com.example.ecommerceupchv2.web.dtos.requests.CreateOrderRequest;
import com.example.ecommerceupchv2.web.dtos.requests.UpdateOrderRequest;
import com.example.ecommerceupchv2.web.dtos.responses.BaseResponse;
import com.example.ecommerceupchv2.services.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("orders")
@RestController
public class OrderController {
}
