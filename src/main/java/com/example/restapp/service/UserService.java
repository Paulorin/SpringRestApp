package com.example.restapp.service;

import com.example.restapp.model.UserListInfo;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    ResponseEntity<List<UserListInfo>> findAll();
    ResponseEntity<UserListInfo> findByName(String username);
}
