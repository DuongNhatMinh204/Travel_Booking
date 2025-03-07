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

//    public UserCreateDTO() {}
//
//    public UserCreateDTO(String phone, String password, String passwordConfirm, String fullName, String email, Date birthday) {
//        this.phone = phone;
//        this.password = password;
//        this.passwordConfirm = passwordConfirm;
//        this.fullName = fullName;
//        this.email = email;
//        this.birthday = birthday;
//    }
//
//    public String getPhone() {
//        return phone;
//    }
//
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getFullName() {
//        return fullName;
//    }
//
//    public void setFullName(String fullName) {
//        this.fullName = fullName;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public Date getBirthday() {
//        return birthday;
//    }
//
//    public void setBirthday(Date birthday) {
//        this.birthday = birthday;
//    }
//
//    public String getPasswordConfirm() {
//        return passwordConfirm;
//    }
//
//    public void setPasswordConfirm(String passwordConfirm) {
//        this.passwordConfirm = passwordConfirm;
//    }
}
