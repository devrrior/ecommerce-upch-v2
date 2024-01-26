package com.example.ecommerceupchv2.security.services;

import com.example.ecommerceupchv2.entities.Role;
import com.example.ecommerceupchv2.entities.User;
import com.example.ecommerceupchv2.repositories.IUserRepository;
import com.example.ecommerceupchv2.security.entities.UserDetailsImpl;
import com.example.ecommerceupchv2.services.IUserRoleService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final IUserRepository userRepository;
    private final IUserRoleService userRoleService;

    public UserDetailsServiceImpl(IUserRepository userRepository, IUserRoleService userRoleService) {
        this.userRepository = userRepository;
        this.userRoleService = userRoleService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findOneByEmail(username)
                .orElseThrow(() -> new RuntimeException("User Not Found with username: " + username));
        List<Role> roles = userRoleService.findAllRoles(user.getId());

        return new UserDetailsImpl(user, getAuthorities(roles));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(Collection<Role> roles) {
        return roles.stream()
                .map(role -> (GrantedAuthority) role::getName)
                .toList();
    }
}
