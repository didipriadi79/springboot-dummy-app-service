package com.priadi.dummyapp.controllers;

import com.priadi.dummyapp.domain.BaseResponse;
import com.priadi.dummyapp.domain.dto.LoginDTO;
import com.priadi.dummyapp.domain.dto.UserDTO;
import com.priadi.dummyapp.domain.request.LoginRequest;
import com.priadi.dummyapp.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HomeController {

    @Autowired
    AuthService authService;
    @RequestMapping(method = RequestMethod.GET, path = "/hello")
    public String helloWord(){
        return "testing halo halo";
    }

    @RequestMapping(method = RequestMethod.POST, path = "/login")
    public BaseResponse<LoginDTO> login(@RequestBody LoginRequest request){
        BaseResponse<LoginDTO> response = new BaseResponse<>();
        response = authService.login(request);
        return response;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/login-online")
    public BaseResponse<LoginDTO> loginOnline(@RequestBody LoginRequest request){
        BaseResponse<LoginDTO> response = new BaseResponse<>();
        response = authService.loginOnline(request);
        return response;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/get-all-user")
    public BaseResponse<List<UserDTO>> getAllUser(){
        BaseResponse<List<UserDTO>> response = new BaseResponse<>();

        List<UserDTO> listUser = new ArrayList<>();
        UserDTO user1 = new UserDTO();
        user1.setId(1L);
        user1.setName("didi");
        user1.setEmail("didi@gmail.com");
        user1.setUsername("didi79");

        UserDTO user2 = new UserDTO();
        user2.setId(2L);
        user2.setName("didi");
        user2.setEmail("didi@gmail.com");
        user2.setUsername("didi79");

        listUser.add(user1);
        listUser.add(user2);
        
        response.setData(listUser);
        return response;
    }
}
