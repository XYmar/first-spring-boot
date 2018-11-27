package com.xy.test.test.controller;

import com.xy.test.test.entity.UserEntity;
import com.xy.test.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping
    public List<UserEntity> getUsers(){
        return userService.getAll();
    }

    @PostMapping
    public UserEntity saveUser(UserEntity userEntity){
        return userService.saveUser(userEntity);
    }
}
