package com.priadi.dummyapp.services;

import com.priadi.dummyapp.domain.BaseResponse;
import com.priadi.dummyapp.domain.dto.LoginDTO;
import com.priadi.dummyapp.domain.request.LoginRequest;

public interface AuthService {
    BaseResponse<LoginDTO> login(LoginRequest request);
    BaseResponse<LoginDTO> loginOnline(LoginRequest request);
}
