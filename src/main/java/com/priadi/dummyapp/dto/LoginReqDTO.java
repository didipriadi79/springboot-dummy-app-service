package com.priadi.dummyapp.dto;

import io.swagger.v3.oas.annotations.Hidden;

public class LoginReqDTO {
    String username;
    String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Hidden
    public boolean isValid(){
        if(getUsername() == null || getPassword() == null){
            return false;
        }
        else if(getUsername().equalsIgnoreCase("") || getPassword().equalsIgnoreCase("")){
            return false;
        }
        else { return true; }
    }
}
