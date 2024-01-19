package com.example.ecommerceupchv2.services;

import com.example.ecommerceupchv2.controllers.dtos.requests.CreateUserRequest;
import com.example.ecommerceupchv2.controllers.dtos.requests.UpdateUserRequest;
import com.example.ecommerceupchv2.controllers.dtos.responses.BaseResponse;
import com.example.ecommerceupchv2.controllers.dtos.responses.GetUserResponse;
import com.example.ecommerceupchv2.entities.User;
import com.example.ecommerceupchv2.repositories.IUserRepository;
import com.example.ecommerceupchv2.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserRepository repository;
    @Override
    public BaseResponse create(CreateUserRequest request) {
        return null;
    }

    @Override
    public BaseResponse get(Long id) {
        return null;
    }

    @Override
    public BaseResponse update(Long id, UpdateUserRequest request) {
        return null;
    }

    @Override
    public BaseResponse delete(Long id) {
        return null;
    }

    private BaseResponse userDoesntExists(){
        return BaseResponse.builder()
                .data(null)
                .message("User doesn't exist")
                .success(Boolean.FALSE)
                .httpStatus(HttpStatus.BAD_REQUEST)
                .build();
    }

    private User toUser(CreateUserRequest request){
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setDateOfBirth(request.getDateOfBirth());

        return user;
    }

    private User toUserUpdate(UpdateUserRequest request, Long id) {
        User user = repository.getUserById(id);
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setDateOfBirth(request.getDateOfBirth());

        return user;
    }

    private GetUserResponse toGetUserResponse(User user) {
        GetUserResponse response = new GetUserResponse();
        response.setId(user.getId());
        response.setEmail(user.getEmail());
        response.setFirstName(user.getFirstName());
        response.setLastName(user.getLastName());
        response.setDateOfBirth(user.getDateOfBirth());

        return response;
    }
}
