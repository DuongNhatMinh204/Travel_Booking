package com.java.web_travel.controller;

import com.java.web_travel.entity.UserEntity;
import com.java.web_travel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> register(@RequestBody UserEntity user) {
        Map<String, Object> response = new HashMap<>();
        try {
            userService.register(user);
            response.put("success", true);
            response.put("message", "Đăng ký thành công");
        } catch (RuntimeException e) {
            response.put("success", false);
            response.put("message", e.getMessage());
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping("/createStaff")
    public ResponseEntity<Map<String, Object>> createStaff(@RequestBody UserEntity user) {
        Map<String, Object> response = new HashMap<>();
        try {
            userService.register(user);
            response.put("success", true);
            response.put("message", "Đăng ký thành công");
        } catch (RuntimeException e) {
            response.put("success", false);
            response.put("message", e.getMessage());
        }
        return ResponseEntity.ok(response);
    }


    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody UserEntity user) {
        UserEntity authenticatedUser = userService.login(user.getTelephone(), user.getPassword());
        Map<String, Object> response = new HashMap<>();

        if (authenticatedUser != null) {
            response.put("success", true);
            response.put("message", "Login successful");

            // Kiểm tra vai trò của người dùng
            if ("admin".equals(authenticatedUser.getRoles())) {
                response.put("redirectUrl", "http://localhost:8080/admin_booking");
            } else {
                response.put("redirectUrl", "http://localhost:8080/home");
            }
        } else {
            response.put("success", false);
            response.put("message", "Invalid telephone or password");
        }

        return ResponseEntity.ok(response);
    }

}
