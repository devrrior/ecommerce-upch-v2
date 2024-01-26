package com.example.ecommerceupchv2.services.impls;

import com.example.ecommerceupchv2.entities.Product;
import com.example.ecommerceupchv2.repositories.IProductRepository;
import com.example.ecommerceupchv2.services.IProductService;
import com.example.ecommerceupchv2.web.dtos.requests.CreateProductRequest;
import com.example.ecommerceupchv2.web.dtos.responses.BaseProductResponse;
import com.example.ecommerceupchv2.web.dtos.responses.BaseResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements IProductService {

    private final IProductRepository repository;
    private final ObjectMapper objectMapper;

    public ProductServiceImpl(IProductRepository repository) {
        this.repository = repository;
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public BaseResponse create(CreateProductRequest request) {
        Product product = repository.save(from(request));

        return BaseResponse.builder()
                .status(HttpStatus.CREATED)
                .statusCode(HttpStatus.CREATED.value())
                .message("Product created successfully")
                .data(toBaseProductResponse(product))
                .build();
    }

    @Override
    public BaseResponse get(Long id) {
        Product product = this.findAndEnsureExist(id);

        return BaseResponse.builder()
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .message("Product retrieved successfully")
                .data(toBaseProductResponse(product))
                .build();
    }

    @Override
    public BaseResponse update(Long id, CreateProductRequest request) {
        return null;
    }

    @Override
    public BaseResponse delete(Long id) {
        return null;
    }

    private Product from(CreateProductRequest request) {
        return objectMapper.convertValue(request, Product.class);
    }

    private BaseProductResponse toBaseProductResponse(Product product) {
        return objectMapper.convertValue(product, BaseProductResponse.class);
    }

    public Product findAndEnsureExist(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }
}
