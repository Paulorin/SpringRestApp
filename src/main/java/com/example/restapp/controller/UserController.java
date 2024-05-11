package com.example.restapp.controller;


import com.example.restapp.api.UserApi;
import com.example.restapp.api.UsersApi;
import com.example.restapp.model.CreateUserRequest;
import com.example.restapp.model.IdResponse;
import com.example.restapp.model.UserListInfo;
import com.example.restapp.service.UserServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserController implements UsersApi, UserApi {
    private final UserServiceImplementation userService;

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return UsersApi.super.getRequest();
    }

    @Override
    public ResponseEntity<List<UserListInfo>> getUsersList() {
        return userService.findAll();
    }

    @Override
    public ResponseEntity<IdResponse> usersPost(CreateUserRequest createUserRequest) {
        return UsersApi.super.usersPost(createUserRequest);
    }


    @Override
    public ResponseEntity<UserListInfo> userGet(String userName) {
        return userService.findByName(userName);
    }
}
