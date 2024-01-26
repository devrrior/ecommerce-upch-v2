package com.example.ecommerceupchv2.web.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductRequest {
    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @NotBlank
    private String imageUrl;

    @NotBlank
    private Integer stock;

    @NotBlank
    private Float price;
}
