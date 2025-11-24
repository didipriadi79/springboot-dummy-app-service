package com.priadi.dummyapp.services.impl;

import com.priadi.dummyapp.AppConstants;
import com.priadi.dummyapp.dto.BaseResDTO;
import com.priadi.dummyapp.dto.LoginDTO;
import com.priadi.dummyapp.model.UserModel;
import com.priadi.dummyapp.repository.UserRepository;
import com.priadi.dummyapp.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
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
    public BaseResDTO<LoginDTO> login(LoginDTO request) {
        BaseResDTO<LoginDTO> response = new BaseResDTO<>();

        if(request.isValid()){
            if(request.getUsername().equalsIgnoreCase(username) && request.getPassword().equalsIgnoreCase(password)){
                LoginDTO dto = new LoginDTO();
                dto.setName(name);
                dto.setEmail(email);
                response.setData(dto);
            }
            else {
                response.setGeneralError(AppConstants.MSG_INVALID_CRED, HttpStatus.FORBIDDEN.value());
            }
        }
        else {
            response.setGeneralError(AppConstants.MSG_INVALID_PAYLOAD, HttpStatus.BAD_REQUEST.value());
        }
        return response;
    }

    @Override
    public BaseResDTO<LoginDTO> loginOnline(LoginDTO request) {
        BaseResDTO<LoginDTO> response = new BaseResDTO<>();

        if(request.isValid()){
            UserModel userModel = repository.findByUsernameAndPassword(request.getUsername(), request.getPassword());
            if(userModel != null){
                LoginDTO dto = new LoginDTO();
                dto.setName(userModel.getName());
                dto.setEmail(userModel.getEmail());
                response.setData(dto);
            }
            else {
                response.setGeneralError(AppConstants.MSG_INVALID_CRED, HttpStatus.FORBIDDEN.value());
            }
        }
        else {
            response.setGeneralError(AppConstants.MSG_INVALID_PAYLOAD, HttpStatus.BAD_REQUEST.value());
        }
        return response;
    }
}
