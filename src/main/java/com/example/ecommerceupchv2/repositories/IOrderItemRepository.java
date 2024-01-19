package com.example.ecommerceupchv2.repositories;

import com.example.ecommerceupchv2.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderItemRepository extends JpaRepository<OrderItem, Long> {
}
