package com.priadi.dummyapp.services;

import com.priadi.dummyapp.dto.BaseResDTO;
import com.priadi.dummyapp.dto.UserDTO;

import java.util.List;

public interface UserService {

    BaseResDTO<List<UserDTO>> getAllUser();
    BaseResDTO<String> addUser(UserDTO user);
    BaseResDTO<String> editUser(UserDTO user);
    BaseResDTO<String> deleteUser(Long id);
    BaseResDTO<UserDTO> detailUser(Long id);
}
