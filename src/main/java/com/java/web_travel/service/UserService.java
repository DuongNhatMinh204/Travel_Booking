package com.java.web_travel.service;

import com.java.web_travel.entity.User;
import com.java.web_travel.model.request.ChangePassDTO;
import com.java.web_travel.model.request.UserCreateDTO;
import com.java.web_travel.model.request.UserLoginDTO;

import java.util.List;

public interface UserService {
    public User createUser(UserCreateDTO userCreateDTO);
    public User loginUser(UserLoginDTO userLoginDTO);
    public void changePassword(ChangePassDTO changePassDto);
    public List<User> getAllUsers();
    public User changeStatus(Long id);
}
