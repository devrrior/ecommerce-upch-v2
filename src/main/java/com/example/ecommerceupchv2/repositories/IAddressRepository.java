package com.example.ecommerceupchv2.repositories;

import com.example.ecommerceupchv2.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAddressRepository extends JpaRepository<Address, Long> {
}
