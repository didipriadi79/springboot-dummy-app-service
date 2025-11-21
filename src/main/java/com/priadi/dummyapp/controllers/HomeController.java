package com.priadi.dummyapp.controllers;

import com.priadi.dummyapp.dto.BaseResDTO;
import com.priadi.dummyapp.dto.LoginResDTO;
import com.priadi.dummyapp.dto.UserResDTO;
import com.priadi.dummyapp.dto.LoginReqDTO;
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
    public BaseResDTO<LoginResDTO> login(@RequestBody LoginReqDTO request){
        BaseResDTO<LoginResDTO> response = new BaseResDTO<>();
        response = authService.login(request);
        return response;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/login-online")
    public BaseResDTO<LoginResDTO> loginOnline(@RequestBody LoginReqDTO request){
        BaseResDTO<LoginResDTO> response = new BaseResDTO<>();
        response = authService.loginOnline(request);
        return response;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/get-all-user")
    public BaseResDTO<List<UserResDTO>> getAllUser(){
        BaseResDTO<List<UserResDTO>> response = new BaseResDTO<>();

        List<UserResDTO> listUser = new ArrayList<>();
        UserResDTO user1 = new UserResDTO();
        user1.setId(1L);
        user1.setName("didi");
        user1.setEmail("didi@gmail.com");
        user1.setUsername("didi79");

        UserResDTO user2 = new UserResDTO();
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
