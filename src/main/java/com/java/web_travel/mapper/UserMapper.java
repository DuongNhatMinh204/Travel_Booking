package com.java.web_travel.mapper;

import com.java.web_travel.entity.UserEntity;
import com.java.web_travel.model.UserModel;
import com.java.web_travel.model.UserProfileModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class UserMapper {
    public abstract UserEntity fromDto(UserModel userModel);
    public abstract UserEntity toDo(UserModel userModel);
}
