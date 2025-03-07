package com.java.web_travel.controller;

import com.java.web_travel.entity.User;
import com.java.web_travel.model.request.ChangePassDTO;
import com.java.web_travel.model.request.UserCreateDTO;
import com.java.web_travel.model.request.UserLoginDTO;
import com.java.web_travel.model.response.ApiReponse;
import com.java.web_travel.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ApiReponse<User> createUser(@Valid  @RequestBody UserCreateDTO userCreateDTO) {
        log.info("User created: " + userCreateDTO);
        ApiReponse<User> apiReponse = new ApiReponse<>();
        apiReponse.setData(userService.createUser(userCreateDTO));
        apiReponse.setMessage("create user success");
        log.info("User created: " + apiReponse);
        return apiReponse;
    }
    @PostMapping("/login")
    public ApiReponse<User> loginUser(@RequestBody UserLoginDTO userLoginDTO) {
        log.info("User login : " + userLoginDTO);
        ApiReponse<User> apiReponse = new ApiReponse<>();
        User user = userService.loginUser(userLoginDTO);
        apiReponse.setData(user);
        apiReponse.setMessage("login user success");
        if(user.getRole().getRoleCode().toString().equals("ADMIN")){
            apiReponse.setCode(8888);
            apiReponse.setMessage("login admin success");
            log.info("Admin login success");
        }
        return apiReponse;
    }
    @PatchMapping("/changePassword")
    public ApiReponse<User> changePassword(@Valid @RequestBody ChangePassDTO changePassDto) {
        log.info("User change password : " + changePassDto);
        userService.changePassword(changePassDto);
        log.info("User change password success");
        return new ApiReponse<>(1000,"success") ;
    }
    @GetMapping("/allUsers")
    public ApiReponse<List<User>> getAllUsers() {
        log.info("User getAllUsers");
        ApiReponse<List<User>> apiReponse = new ApiReponse<>();
        apiReponse.setData(userService.getAllUsers());
        apiReponse.setMessage("get all users success");
        log.info("User getAllUsers success");
        return apiReponse ;
    }
    @PatchMapping("/changeStatus/{id}")
    public ApiReponse<User> changeStatus(@PathVariable Long id) {
        log.info("User change status id = {} : ", id);
        ApiReponse<User> apiReponse = new ApiReponse<>();
        apiReponse.setData(userService.changeStatus(id));
        apiReponse.setMessage("change status success");
        log.info("User change status success");
        return apiReponse;
    }
}
