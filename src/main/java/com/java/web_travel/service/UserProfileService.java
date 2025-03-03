package com.java.web_travel.service;

import com.java.web_travel.entity.UserEntity;
import com.java.web_travel.entity.UserProfileEntity;
import com.java.web_travel.model.UserModel;

public interface UserProfileService {
    UserEntity createUser(String username, String password, String email, String phone);

    UserProfileEntity getUserById(Integer id);

    UserProfileEntity updateProfile(Integer userId, String fullName, String telephone, String email);


    UserModel findUserById(Integer id);
}
