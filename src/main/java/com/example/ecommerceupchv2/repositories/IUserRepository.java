package com.example.ecommerceupchv2.repositories;

import com.example.ecommerceupchv2.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository <User, Long> {
    Boolean existsUserByEmail(String email);
    Boolean existsUserById(Long id);
    User getUserById(Long id);
}