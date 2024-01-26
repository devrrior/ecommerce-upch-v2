package com.example.ecommerceupchv2.services.impls;

import com.example.ecommerceupchv2.entities.User;
import com.example.ecommerceupchv2.services.IAuthService;
import com.example.ecommerceupchv2.services.IUserService;
import com.example.ecommerceupchv2.types.JWTType;
import com.example.ecommerceupchv2.utils.JWTUtils;
import com.example.ecommerceupchv2.web.dtos.requests.AuthenticateRequest;
import com.example.ecommerceupchv2.web.dtos.responses.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AuthServiceImpl implements IAuthService {

    private final IUserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JWTUtils jwtUtils;

    public AuthServiceImpl(IUserService userService, PasswordEncoder passwordEncoder, JWTUtils jwtUtils) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtils = jwtUtils;
    }

    @Override
    public BaseResponse authenticate(AuthenticateRequest request) {
        User user = userService.findOneAndEnsureExist(request.getEmail());

        if (!this.isPasswordCorrect(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Password incorrect");
        }

        Map<String, Object> payload = Map.of("firstName", user.getFirstName(), "lastName", user.getLastName());
        String accessToken = jwtUtils.generateAccessToken(user.getEmail(), payload, JWTType.ACCESS_TOKEN);

        Map<String, String> data = Map.of("accessToken", accessToken);

        return BaseResponse.builder()
                .data(data)
                .message("User authenticated")
                .success(Boolean.TRUE)
                .status(HttpStatus.CREATED)
                .statusCode(HttpStatus.CREATED.value())
                .build();
    }

    private Boolean isPasswordCorrect(String password, String encodedPassword) {
        return passwordEncoder.matches(password, encodedPassword);
    }

}
