package com.java.web_travel.model;

import com.java.web_travel.entity.UserProfileEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {

    private Long id;

    @Schema(description = "telephone", example = "0387330657")
    private String telephone;

    @Schema(description = "username", example = "thangdv")
    private String userName;

    @Schema(description = "password", example = "12345678")
    private String password;

    @Schema(description = "email address", example = "thangdangsad@gmail.com")
    private String email;

    @Schema(description = "roles", example = "admin")
    private String roles;

}
