package com.priadi.dummyapp.controllers;

import com.priadi.dummyapp.AppConstants;
import com.priadi.dummyapp.dto.BaseResDTO;
import com.priadi.dummyapp.dto.UserDTO;
import com.priadi.dummyapp.model.UserModel;
import com.priadi.dummyapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    @RequestMapping(method = RequestMethod.GET, path = "/get-all")
    public BaseResDTO<List<UserDTO>> getAllUser(){
        BaseResDTO<List<UserDTO>> response = new BaseResDTO<>();
        response = userService.getAllUser();

        return response;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/add")
    public BaseResDTO<String> addUser(@RequestBody UserDTO request){
        BaseResDTO<String> response = new BaseResDTO<>();
        if(request.isValid()){
            response = userService.addUser(request);
        }
        else {
            response.setGeneralError(AppConstants.MSG_INVALID_PAYLOAD, HttpStatus.BAD_REQUEST.value());
        }
        return response;
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/edit")
    public BaseResDTO<String> editUser(@RequestBody UserDTO request){
        BaseResDTO<String> response = new BaseResDTO<>();
        if(request.isValid() && request.getId() != null){
            response = userService.editUser(request);
        }
        else {
            response.setGeneralError(AppConstants.MSG_INVALID_PAYLOAD, HttpStatus.BAD_REQUEST.value());
        }
        return response;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public BaseResDTO<UserDTO> detailUser(@PathVariable("id") Long id){
        BaseResDTO<UserDTO> response = new BaseResDTO<>();
        if(id != null){
            response = userService.detailUser(id);
        }
        else {
            response.setGeneralError(AppConstants.MSG_INVALID_PAYLOAD, HttpStatus.BAD_REQUEST.value());
        }
        return response;
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public BaseResDTO<String> deleteUser(@PathVariable("id") Long id){
        BaseResDTO<String> response = new BaseResDTO<>();
        if(id != null){
            response = userService.deleteUser(id);
        }
        else {
            response.setGeneralError(AppConstants.MSG_INVALID_PAYLOAD, HttpStatus.BAD_REQUEST.value());
        }
        return response;
    }
}
