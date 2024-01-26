package com.example.ecommerceupchv2.services;

import com.example.ecommerceupchv2.web.dtos.requests.CreateProductRequest;
import com.example.ecommerceupchv2.web.dtos.responses.BaseProductResponse;
import com.example.ecommerceupchv2.web.dtos.responses.BaseResponse;

public interface IProductService {
    BaseResponse create(CreateProductRequest request);
    BaseResponse get(Long id);
    BaseResponse update(Long id, CreateProductRequest request);
    BaseResponse delete(Long id);
}
