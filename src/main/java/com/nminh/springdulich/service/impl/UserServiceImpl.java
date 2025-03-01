package com.nminh.springdulich.service.impl;

import com.nminh.springdulich.entity.Role;
import com.nminh.springdulich.entity.User;
import com.nminh.springdulich.enums.ErrorCode;
import com.nminh.springdulich.enums.RoleCode;
import com.nminh.springdulich.exception.AppException;
import com.nminh.springdulich.model.request.ChangePassDTO;
import com.nminh.springdulich.model.request.UserCreateDTO;
import com.nminh.springdulich.model.request.UserLoginDTO;
import com.nminh.springdulich.repository.RoleRepository;
import com.nminh.springdulich.repository.UserRepository;
import com.nminh.springdulich.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public User createUser(UserCreateDTO userCreateDTO) {
        // CHECK MATCH PASSWORD
        if(!userCreateDTO.getPassword().equals(userCreateDTO.getPasswordConfirm())){
            throw new AppException(ErrorCode.PASSWORD_MISMATCH) ;
        }
        // check exist phone
        if(userRepository.existsByPhone(userCreateDTO.getPhone())) {
            throw new AppException(ErrorCode.USER_EXISTS) ;
        }

        User user = new User();

        user.setPhone(userCreateDTO.getPhone());
        user.setPassword(userCreateDTO.getPassword());
        user.setFullName(userCreateDTO.getFullName());
        user.setEmail(userCreateDTO.getEmail());
        user.setBirthday(userCreateDTO.getBirthday());

        Role role = roleRepository.findByRoleCode(RoleCode.USER)
                        .orElseThrow(()->new AppException(ErrorCode.ROLE_NOT_FOUND)) ;
        user.setRole(role);

        user.setStatus(true);
        return userRepository.save(user);
    }

    @Override
    public User loginUser(UserLoginDTO userLoginDTO) {
        User user = userRepository.findByPhone(userLoginDTO.getPhone())
                .orElseThrow(() -> new AppException(ErrorCode.PHONE_NOT_EXISTS));

        if(!user.isStatus()){
            throw new AppException(ErrorCode.ACCOUNT_NOT_ACTIVE);
        }
        String password = userLoginDTO.getPassword();
        if(!user.getPassword().equals(password)){
           throw new AppException(ErrorCode.PASSWORD_MISMATCH) ;
        }else{
            return user;
        }
    }

    @Override
    public void changePassword(ChangePassDTO changePassDTO) {
        if(!changePassDTO.getNewPassword().equals(changePassDTO.getConfirmPassword())){
            throw new AppException(ErrorCode.PASSWORD_MISMATCH) ;
        }

        User user = userRepository.findByPhone(changePassDTO.getPhone()).
                    orElseThrow(()-> new AppException(ErrorCode.USER_NOT_EXISTS));

        if(!user.getPassword().equals(changePassDTO.getPassword())){
            throw new AppException(ErrorCode.WRONG_PASSWORD) ;
        }

        user.setPassword(changePassDTO.getNewPassword());
        userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }

    @Override
    public User changeStatus(Long id) {
        User user = userRepository.findById(id).orElseThrow(()-> new AppException(ErrorCode.USER_NOT_EXISTS));
        user.setStatus(!user.isStatus());
        return userRepository.save(user);
    }


}
