package com.priadi.dummyapp.controllers;

import com.priadi.dummyapp.domain.BaseResponse;
import com.priadi.dummyapp.domain.dto.LoginDTO;
import com.priadi.dummyapp.domain.request.LoginRequest;
import com.priadi.dummyapp.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
