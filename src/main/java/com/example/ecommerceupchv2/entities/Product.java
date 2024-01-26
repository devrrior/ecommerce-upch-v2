package com.example.ecommerceupchv2.entities;

import com.example.ecommerceupchv2.entities.pivots.ProductCategory;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "products")
@Setter
@Getter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200)
    private String title;

    private String description;

    private String imageUrl;

    private Integer stock;

    private Float price;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonManagedReference
    private User user;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductCategory> productCategories;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<OrderItem> orderItems;

    @ManyToOne
    @JoinColumn(name = "productStatus_id")
    @JsonManagedReference
    private ProductStatus productStatus;

}