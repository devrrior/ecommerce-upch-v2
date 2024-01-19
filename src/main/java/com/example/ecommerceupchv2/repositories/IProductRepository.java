package com.example.ecommerceupchv2.repositories;

import com.example.ecommerceupchv2.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Long> {
}
