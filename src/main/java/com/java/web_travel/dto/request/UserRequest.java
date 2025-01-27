package com.java.web_travel.dto.request;

import jakarta.persistence.Column;

public class UserRequest {

    private String telephone;


    private String password;


    private String roles;

    public UserRequest() {}
    public UserRequest(String telephone, String password, String roles) {
        this.telephone = telephone;
        this.password = password;
        this.roles = roles;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}
