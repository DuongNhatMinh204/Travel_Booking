package com.java.web_travel.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
public class UserCreateDTO {
    @NotBlank(message = "ARGUMENT_NOT_VALID")
    private String phone ;
    @NotBlank(message = "ARGUMENT_NOT_VALID")
    private String password ;
    @NotBlank(message = "ARGUMENT_NOT_VALID")
    private String passwordConfirm ;
    @NotBlank(message = "ARGUMENT_NOT_VALID")
    private String fullName ;
    @Email(message = "EMAIL_NOT_VALID")
    private String email ;
    private Date birthday ;
}
