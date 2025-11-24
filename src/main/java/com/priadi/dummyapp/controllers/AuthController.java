package com.priadi.dummyapp.controllers;

import com.priadi.dummyapp.dto.BaseResDTO;
import com.priadi.dummyapp.dto.LoginDTO;
import com.priadi.dummyapp.services.AuthService;
import com.priadi.dummyapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @RequestMapping(method = RequestMethod.GET, path = "/hello")
    public String helloWord(){
        return "testing halo halo";
    }

    @RequestMapping(method = RequestMethod.POST, path = "/login")
    public BaseResDTO<LoginDTO> login(@RequestBody LoginDTO request){
        BaseResDTO<LoginDTO> response = new BaseResDTO<>();
        response = authService.login(request);
        return response;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/login-online")
    public BaseResDTO<LoginDTO> loginOnline(@RequestBody LoginDTO request){
        BaseResDTO<LoginDTO> response = new BaseResDTO<>();
        response = authService.loginOnline(request);
        return response;
    }
}
