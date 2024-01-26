package com.example.ecommerceupchv2.web.dtos.responses;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class BaseProductResponse {
    private String title;
    private String description;
    private String imageUrl;
    private Integer stock;
    private Float price;
}
