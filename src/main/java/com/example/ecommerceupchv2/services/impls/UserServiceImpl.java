package com.example.ecommerceupchv2.services.impls;

import com.example.ecommerceupchv2.entities.User;
import com.example.ecommerceupchv2.repositories.IUserRepository;
import com.example.ecommerceupchv2.services.IUserService;
import com.example.ecommerceupchv2.utils.AuthenticationUtils;
import com.example.ecommerceupchv2.web.dtos.requests.CreateUserRequest;
import com.example.ecommerceupchv2.web.dtos.requests.UpdateUserRequest;
import com.example.ecommerceupchv2.web.dtos.responses.BaseResponse;
import com.example.ecommerceupchv2.web.dtos.responses.CreateUserResponse;
import com.example.ecommerceupchv2.web.dtos.responses.UpdateUserResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    private final IUserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationUtils authenticationUtils;

    public UserServiceImpl(IUserRepository repository, PasswordEncoder passwordEncoder, AuthenticationUtils authenticationUtils) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationUtils = authenticationUtils;
    }

    @Override
    public BaseResponse get(Long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User authenticatedUser = authenticationUtils.getUserAuthenticated(authentication);
        if (!authenticatedUser.getId().equals(id)) {
            throw new RuntimeException("Denied access");
        }

        User user = this.findOneAndEnsureExist(id);

        return BaseResponse.builder()
                .data(toCreateUserResponse(user))
                .message("User retrieved")
                .success(Boolean.TRUE)
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .build();
    }

    @Override
    public BaseResponse create(CreateUserRequest request) {
        if (repository.findOneByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("User already exists");
        }

        User user = repository.save(from(request));

        return BaseResponse.builder()
                .data(toCreateUserResponse(user))
                .message("User created")
                .success(Boolean.TRUE)
                .status(HttpStatus.CREATED)
                .statusCode(HttpStatus.CREATED.value())
                .build();
    }

    @Override
    public BaseResponse update(Long id, UpdateUserRequest request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User authenticatedUser = authenticationUtils.getUserAuthenticated(authentication);

        if(!authenticatedUser.getId().equals(id)) {
            throw new RuntimeException("Denied access");
        }

        User user = this.findOneAndEnsureExist(id);

        user.setEmail(request.getEmail());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setDateOfBirth(request.getDateOfBirth());

        User updatedUser = repository.save(user);

        return BaseResponse.builder()
                .data(toUpdateUserResponse(updatedUser))
                .message("User updated")
                .success(Boolean.TRUE)
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .build();
    }

    @Override
    public BaseResponse delete(Long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User authenticatedUser = authenticationUtils.getUserAuthenticated(authentication);

        if(!authenticatedUser.getId().equals(id)) {
            throw new RuntimeException("Denied access");
        }

        User user = this.findOneAndEnsureExist(id);

        repository.delete(user);

        return BaseResponse.builder()
                .message("User deleted")
                .success(Boolean.TRUE)
                .status(HttpStatus.NO_CONTENT)
                .statusCode(HttpStatus.OK.value())
                .build();
    }

    @Override
    public User findOneAndEnsureExist(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("User doesn't exist"));
    }

    @Override
    public User findOneAndEnsureExist(String email) {
        return repository.findOneByEmail(email).orElseThrow(() -> new RuntimeException("User doesn't exist"));
    }

    private User from(CreateUserRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(encodePassword(request.getPassword()));
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setDateOfBirth(request.getDateOfBirth());

        return user;
    }

    private CreateUserResponse toCreateUserResponse(User user) {
        ObjectMapper mapper = new ObjectMapper();

        return mapper.convertValue(user, CreateUserResponse.class);
    }

    private UpdateUserResponse toUpdateUserResponse(User user) {
        ObjectMapper mapper = new ObjectMapper();

        return mapper.convertValue(user, UpdateUserResponse.class);
    }

    private String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }
}
