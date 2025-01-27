package com.java.web_travel.service.impl;

import com.java.web_travel.entity.User;
import com.java.web_travel.repository.UserRepository;
import com.java.web_travel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean validateUser(String telephone, String password) {
        User user = userRepository.findByTelephone(telephone);
        if (user != null && user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }
}
