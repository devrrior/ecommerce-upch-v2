package com.example.ecommerceupchv2.services.impls;

import com.example.ecommerceupchv2.entities.Role;
import com.example.ecommerceupchv2.entities.projections.RoleProjection;
import com.example.ecommerceupchv2.repositories.IUserRoleRepository;
import com.example.ecommerceupchv2.services.IUserRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl implements IUserRoleService {

    private final IUserRoleRepository repository;

    public UserRoleServiceImpl(IUserRoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Role> findAllRoles(Long userId) {
        List<RoleProjection> roles = repository.findAllRolesByUserId(userId);

        return roles.stream()
                .map(this::from)
                .toList();
    }

    private Role from(RoleProjection projection) {
        Role role = new Role();

        role.setId(projection.getId());
        role.setName(projection.getName());

        return role;
    }
}
