package com.nminh.springdulich.controller;

import com.nminh.springdulich.entity.User;
import com.nminh.springdulich.model.request.ChangePassDTO;
import com.nminh.springdulich.model.request.UserCreateDTO;
import com.nminh.springdulich.model.request.UserLoginDTO;
import com.nminh.springdulich.model.response.ApiReponse;
import com.nminh.springdulich.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ApiReponse<User> createUser(@Valid  @RequestBody UserCreateDTO userCreateDTO) {
        ApiReponse<User> apiReponse = new ApiReponse<>();
        apiReponse.setData(userService.createUser(userCreateDTO));
        apiReponse.setMessage("create user success");
        return apiReponse;
    }
    @PostMapping("/login")
    public ApiReponse<User> loginUser(@RequestBody UserLoginDTO userLoginDTO) {
        ApiReponse<User> apiReponse = new ApiReponse<>();
        User user = userService.loginUser(userLoginDTO);
        apiReponse.setData(user);
        apiReponse.setMessage("login user success");
        if(user.getRole().getRoleCode().toString().equals("ADMIN")){
            apiReponse.setCode(8888);
            apiReponse.setMessage("login admin success");
        }
        return apiReponse;
    }
    @PatchMapping("/changePassword")
    public ApiReponse<User> changePassword(@Valid @RequestBody ChangePassDTO changePassDto) {
        userService.changePassword(changePassDto);
        return new ApiReponse<>(1000,"success") ;
    }
    @GetMapping("/allUsers")
    public ApiReponse<List<User>> getAllUsers() {
        ApiReponse<List<User>> apiReponse = new ApiReponse<>();
        apiReponse.setData(userService.getAllUsers());
        apiReponse.setMessage("get all users success");
        return apiReponse ;
    }
    @PatchMapping("/changeStatus/{id}")
    public ApiReponse<User> changeStatus(@PathVariable Long id) {
        ApiReponse<User> apiReponse = new ApiReponse<>();
        apiReponse.setData(userService.changeStatus(id));
        apiReponse.setMessage("change status success");
        return apiReponse;
    }
}
