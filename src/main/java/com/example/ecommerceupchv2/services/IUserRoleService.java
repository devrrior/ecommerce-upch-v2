package com.example.ecommerceupchv2.services;

import com.example.ecommerceupchv2.entities.Role;

import java.util.List;

public interface IUserRoleService {
    List<Role> findAllRoles(Long userId);
}
