package com.java.web_travel.service.Impl;

import com.java.web_travel.entity.UserEntity;
import com.java.web_travel.entity.UserProfileEntity;
import com.java.web_travel.repository.UserProfileRepository;
import com.java.web_travel.repository.UserRepository;
import com.java.web_travel.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileServiceImpl implements UserProfileService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Override
    public UserEntity createUser(String username, String password, String email, String phone) {
        // Tạo User
        UserEntity user = new UserEntity();
        user.setUserName(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setTelephone(phone);

        // Tạo UserProfile mặc định
        UserProfileEntity userProfile = new UserProfileEntity();
        userProfile.setFullName(username); // Fullname mặc định là username
        userProfile.setPhoneNumber(phone);  // Telephone mặc định là phone của User
        userProfile.setEmail(email);      // Email đồng bộ với User
        // Gắn UserProfile vào User
        user.addUserProfile(userProfile);

        // Lưu User và UserProfile
        return userRepository.save(user); // Cascade sẽ lưu cả UserProfile
    }

    @Override
    public UserProfileEntity getUserById(Long userId) {
        return userProfileRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
    @Override
    public UserProfileEntity updateProfile(Long userId, String fullName, String telephone, String email) {
        // Tìm User
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        UserProfileEntity userProfile = user.getUserProfile();
        if (userProfile == null) {
            throw new RuntimeException("UserProfile not found for user ID: " + userId);
        }

        // Cập nhật UserProfile
        if (fullName != null) {
            userProfile.setFullName(fullName); // Fullname có thể thay đổi độc lập
        }
        if (telephone != null) {
            userProfile.setPhoneNumber(telephone); // Telephone có thể thay đổi độc lập
        }
        if (email != null) {
            user.setEmail(email); // Đồng bộ email với User
            userProfile.setEmail(email);
        }

        return userProfileRepository.save(userProfile);
    }


}
