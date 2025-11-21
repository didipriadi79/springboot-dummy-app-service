package com.priadi.dummyapp.services.impl;

import com.priadi.dummyapp.dto.BaseResDTO;
import com.priadi.dummyapp.dto.LoginResDTO;
import com.priadi.dummyapp.dto.LoginReqDTO;
import com.priadi.dummyapp.model.UserModel;
import com.priadi.dummyapp.repository.UserRepository;
import com.priadi.dummyapp.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    UserRepository repository;

    @Value("${login.username}")
    private String username;

    @Value("${login.password}")
    private String password;

    @Value("${login.name}")
    private String name;

    @Value("${login.email}")
    private String email;
    @Override
    public BaseResDTO<LoginResDTO> login(LoginReqDTO request) {
        BaseResDTO<LoginResDTO> response = new BaseResDTO<>();

        if(request.isValid()){
            if(request.getUsername().equalsIgnoreCase(username) && request.getPassword().equalsIgnoreCase(password)){
                LoginResDTO dto = new LoginResDTO();
                dto.setName(name);
                dto.setEmail(email);
                response.setData(dto);
            }
            else {
                response.setGeneralError("invalid username or password", 403);
            }
        }
        else {
            response.setGeneralError("invalid payload", 400);
        }
        return response;
    }

    @Override
    public BaseResDTO<LoginResDTO> loginOnline(LoginReqDTO request) {
        BaseResDTO<LoginResDTO> response = new BaseResDTO<>();

        if(request.isValid()){
            UserModel userModel = repository.findByUsernameAndPassword(request.getUsername(), request.getPassword());
            if(userModel != null){
                LoginResDTO dto = new LoginResDTO();
                dto.setName(userModel.getName());
                dto.setEmail(userModel.getEmail());
                response.setData(dto);
            }
            else {
                response.setGeneralError("invalid username or password", 403);
            }
        }
        else {
            response.setGeneralError("invalid payload", 400);
        }
        return response;
    }
}
