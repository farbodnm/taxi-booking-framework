package com.taxi.user.service;

import com.taxi.user.dto.BaseUserSigninDTO;
import lombok.experimental.SuperBuilder;
import org.springframework.stereotype.Service;


public interface AuthService<T extends BaseUserSigninDTO> {
    T signIn(T dto);
}
