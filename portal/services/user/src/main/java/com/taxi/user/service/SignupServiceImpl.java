package com.taxi.user.service;

import com.taxi.framework.user.dto.BaseUserSignupDTO;
import com.taxi.framework.user.service.SignupService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("SignupService")
public class SignupServiceImpl implements SignupService<BaseUserSignupDTO> {
    @Override
    public BaseUserSignupDTO signUp(BaseUserSignupDTO dto) {
        return dto;
    }
}
