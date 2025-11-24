package com.priadi.dummyapp.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.priadi.dummyapp.AppConstants;
import com.priadi.dummyapp.dto.BaseResDTO;
import com.priadi.dummyapp.dto.UserDTO;
import com.priadi.dummyapp.model.UserModel;
import com.priadi.dummyapp.repository.UserRepository;
import com.priadi.dummyapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repository;
    private final ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public BaseResDTO<List<UserDTO>> getAllUser() {
        BaseResDTO<List<UserDTO>> response = new BaseResDTO<>();
        List<UserModel> listUser = repository.findAll();

        List<UserDTO> resUser = new ArrayList<>();
        for(UserModel u: listUser){
            resUser.add(objectMapper.convertValue(u, UserDTO.class));
        }

        response.setData(resUser);
        return response;
    }

    @Override
    public BaseResDTO<String> addUser(UserDTO user) {
        BaseResDTO<String> response = new BaseResDTO<>();
        try {
            UserModel userModel = objectMapper.convertValue(user, UserModel.class);
            repository.save(userModel);
        } catch (Exception e){
            System.out.println(e.getMessage());
            response.setGeneralError(AppConstants.MSG_GENERAL_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
        return response;
    }

    @Override
    public BaseResDTO<String> editUser(UserDTO user) {
        BaseResDTO<String> response = new BaseResDTO<>();
        try {
            Optional<UserModel> userGet = repository.findById(user.getId());
            if(userGet.isPresent()){
                UserModel userModel = userGet.get();
                userModel.setEmail(user.getEmail());
                userModel.setName(user.getName());
                userModel.setPassword(user.getPassword());
                userModel.setUsername(user.getUsername());
                repository.save(userModel);
            }
            else {
                response.setGeneralError(AppConstants.MSG_DATA_NOT_FOUND, HttpStatus.INTERNAL_SERVER_ERROR.value());
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
            response.setGeneralError(AppConstants.MSG_GENERAL_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
        return response;
    }

    @Override
    public BaseResDTO<String> deleteUser(Long id) {
        BaseResDTO<String> response = new BaseResDTO<>();
        try {
            Optional<UserModel> userGet = repository.findById(id);
            if(userGet.isPresent()){
                repository.delete(userGet.get());
            }
            else {
                response.setGeneralError(AppConstants.MSG_DATA_NOT_FOUND, HttpStatus.INTERNAL_SERVER_ERROR.value());
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
            response.setGeneralError(AppConstants.MSG_GENERAL_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
        return response;
    }

    @Override
    public BaseResDTO<UserDTO> detailUser(Long id) {
        BaseResDTO<UserDTO> response = new BaseResDTO<>();
        try {
            Optional<UserModel> userGet = repository.findById(id);
            if(userGet.isPresent()){
                response.setData(objectMapper.convertValue(userGet.get(), UserDTO.class));
            }
            else {
                response.setGeneralError(AppConstants.MSG_DATA_NOT_FOUND, HttpStatus.INTERNAL_SERVER_ERROR.value());
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
            response.setGeneralError(AppConstants.MSG_GENERAL_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
        return response;
    }
}
