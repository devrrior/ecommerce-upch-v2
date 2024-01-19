package com.example.ecommerceupchv2.repositories;

import com.example.ecommerceupchv2.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Long> {
    @Query
    Order getOrderById(Long Id);
    Boolean existsOrderByStatus(String status);

    Order findByStatus(String status);

}