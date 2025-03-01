package com.java.web_travel.model.request;

import jakarta.validation.constraints.NotBlank;

public class ChangePassDTO {
    @NotBlank(message = "ARGUMENT_NOT_VALID")
    private String phone ;
    @NotBlank(message = "ARGUMENT_NOT_VALID")
    private String password ;
    @NotBlank(message = "ARGUMENT_NOT_VALID")
    private String newPassword ;
    @NotBlank(message = "ARGUMENT_NOT_VALID")
    private String confirmPassword ;
    public ChangePassDTO(){}
    public ChangePassDTO(String phone, String password, String newPassword, String confirmPassword) {
        this.phone = phone;
        this.password = password;
        this.newPassword = newPassword;
        this.confirmPassword = confirmPassword;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
