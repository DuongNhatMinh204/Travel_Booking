package com.nminh.springdulich.service;

import com.nminh.springdulich.entity.User;
import com.nminh.springdulich.model.request.ChangePassDTO;
import com.nminh.springdulich.model.request.UserCreateDTO;
import com.nminh.springdulich.model.request.UserLoginDTO;

import java.util.List;

public interface UserService {
    public User createUser(UserCreateDTO userCreateDTO);
    public User loginUser(UserLoginDTO userLoginDTO);
    public void changePassword(ChangePassDTO changePassDto);
    public List<User> getAllUsers();
    public User changeStatus(Long id);
}
