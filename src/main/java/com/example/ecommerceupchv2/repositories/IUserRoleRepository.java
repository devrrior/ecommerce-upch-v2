package com.example.ecommerceupchv2.repositories;

import com.example.ecommerceupchv2.entities.pivots.UserRole;
import com.example.ecommerceupchv2.entities.projections.RoleProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IUserRoleRepository extends JpaRepository<UserRole, Long> {

    @Query(value = "SELECT * FROM users_roles WHERE user_id = ?1", nativeQuery = true)
    List<RoleProjection> findAllRolesByUserId(Long id);
}
