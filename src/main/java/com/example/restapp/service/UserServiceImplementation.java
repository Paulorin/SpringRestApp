package com.example.restapp.service;

import com.example.restapp.Entity.User;
import com.example.restapp.model.UserListInfo;
import com.example.restapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserServiceImplementation implements UserService {

    private final UserRepository userRepository;

    @Override
    public ResponseEntity<List<UserListInfo>> findAll() {
        List<User> userListInfos = userRepository.findAll();

        List<UserListInfo> userInfosList = new ArrayList<>();
        for (User user : userListInfos) {
            UserListInfo userListInfo = new UserListInfo();
            userListInfo.setUserId(user.getUserId());
            userListInfo.setUserName(user.getUserName());
            userListInfo.setUserAge(user.getUserAge());
            userInfosList.add(userListInfo);
        }
        return new ResponseEntity<>(userInfosList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserListInfo> findByName(String username) {
        User user = userRepository.findByUserName(username);
        UserListInfo userListInfo = new UserListInfo();
        userListInfo.setUserId(user.getUserId());
        userListInfo.setUserName(user.getUserName());
        userListInfo.setUserAge(user.getUserAge());
        return new ResponseEntity<>(userListInfo, HttpStatus.OK);
    }
}
