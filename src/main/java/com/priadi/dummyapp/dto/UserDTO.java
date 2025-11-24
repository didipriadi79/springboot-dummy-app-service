package com.priadi.dummyapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.Hidden;

public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private String username;
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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
    @JsonIgnore
    public boolean isValidForAdd(){
        if(
            getName() == null || getName().equalsIgnoreCase("") ||
            getPassword() == null || getPassword().equalsIgnoreCase("") ||
            getEmail() == null || getEmail().equalsIgnoreCase("") ||
            getUsername() == null || getUsername().equalsIgnoreCase("")
        ){
            return false;
        }
        else {
            return true;
        }
    }

    @Hidden
    @JsonIgnore
    public boolean isValidForEdit(){
        if(
            getId() == null ||
            getName() == null || getName().equalsIgnoreCase("") ||
            getEmail() == null || getEmail().equalsIgnoreCase("")
        ){
            return false;
        }
        else {
            return true;
        }
    }
}
