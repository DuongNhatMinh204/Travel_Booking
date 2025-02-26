package com.java.web_travel.service;

import com.java.web_travel.entity.UserEntity;
import com.java.web_travel.entity.UserProfileEntity;

public interface UserProfileService {
    UserEntity createUser(String username, String password, String email, String phone);

    UserProfileEntity getUserById(Long userId);

    UserProfileEntity updateProfile(Long userId, String fullName, String telephone, String email);
}
