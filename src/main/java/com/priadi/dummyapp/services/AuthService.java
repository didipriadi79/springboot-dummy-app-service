package com.priadi.dummyapp.services;

import com.priadi.dummyapp.dto.BaseResDTO;
import com.priadi.dummyapp.dto.LoginResDTO;
import com.priadi.dummyapp.dto.LoginReqDTO;

public interface AuthService {
    BaseResDTO<LoginResDTO> login(LoginReqDTO request);
    BaseResDTO<LoginResDTO> loginOnline(LoginReqDTO request);
}
