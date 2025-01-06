package com.java.web_travel.service;

import com.java.web_travel.entity.UserEntity;
import com.java.web_travel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserEntity register(UserEntity user) {
        if (userRepository.findByTelephone(user.getTelephone()).isPresent()) {
            throw new RuntimeException("Số điện thoại đã tồn tại. Vui lòng chọn số điện thoại khác.");
        }
        // Kiểm tra độ dài mật khẩu
        if (user.getPassword().length() < 8) {
            throw new RuntimeException("Mật khẩu phải có ít nhất 8 ký tự.");
        }
        return userRepository.save(user);
    }

    public UserEntity login(String telephone, String password) {
        Optional<UserEntity> user = userRepository.findByTelephone(telephone);
        if (user.isPresent() && password.equals(user.get().getPassword())) { // So sánh mật khẩu thường
            return user.get();
        }
        throw new RuntimeException("Invalid ");
    }
}
