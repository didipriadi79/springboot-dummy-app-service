package com.priadi.dummyapp.services;

import com.priadi.dummyapp.dto.BaseResDTO;
import com.priadi.dummyapp.dto.LoginDTO;

public interface AuthService {
    BaseResDTO<LoginDTO> login(LoginDTO request);
    BaseResDTO<LoginDTO> loginOnline(LoginDTO request);

}
