package com.priadi.dummyapp.services.impl;

import com.priadi.dummyapp.domain.BaseResponse;
import com.priadi.dummyapp.domain.dto.LoginDTO;
import com.priadi.dummyapp.domain.request.LoginRequest;
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
    public BaseResponse<LoginDTO> login(LoginRequest request) {
        BaseResponse<LoginDTO> response = new BaseResponse<>();

        if(request.isValid()){
            if(request.getUsername().equalsIgnoreCase(username) && request.getPassword().equalsIgnoreCase(password)){
                LoginDTO dto = new LoginDTO();
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
    public BaseResponse<LoginDTO> loginOnline(LoginRequest request) {
        BaseResponse<LoginDTO> response = new BaseResponse<>();

        if(request.isValid()){
            UserModel userModel = repository.findByUsernameAndPassword(request.getUsername(), request.getPassword());
            if(userModel != null){
                LoginDTO dto = new LoginDTO();
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
