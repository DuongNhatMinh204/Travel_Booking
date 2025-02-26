package com.java.web_travel.mapper;

import com.java.web_travel.entity.UserProfileEntity;
import com.java.web_travel.model.UserProfileModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class UserProfileMapper {
    public abstract UserProfileEntity fromDto(UserProfileModel userProfileModel);

    public abstract UserProfileModel ToDo(UserProfileEntity userProfile);
}
