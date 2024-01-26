package com.example.ecommerceupchv2.utils;

import com.example.ecommerceupchv2.entities.User;
import com.example.ecommerceupchv2.security.entities.UserDetailsImpl;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationUtils {
    public User getUserAuthenticated(Authentication authentication) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        return userDetails.getUser();
    }
}
