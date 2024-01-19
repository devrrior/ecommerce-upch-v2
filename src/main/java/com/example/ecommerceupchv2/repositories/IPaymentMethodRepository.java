package com.example.ecommerceupchv2.repositories;

import com.example.ecommerceupchv2.entities.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {
}
