package com.java.web_travel.model;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileModel {

    private Long id;

    @Schema(description = "Full Name", example = "Dương Văn Thắng")
    private String fullName;

    @Schema(description = "email address", example = "thangdangsad@gmail.com")
    private String email;

    @Schema(description = "telephone", example = "0387330657")
    private String phoneNumber;

}
