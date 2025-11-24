package com.priadi.dummyapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.Hidden;

public class LoginDTO {
    String username;
    String password;
    String email;
    String name;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Hidden
    @JsonIgnore
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
