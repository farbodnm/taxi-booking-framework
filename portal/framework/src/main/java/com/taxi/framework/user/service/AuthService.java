package com.taxi.framework.user.service;

import com.taxi.framework.user.dto.BaseUserSigninDTO;


public interface AuthService<T extends BaseUserSigninDTO> {
    T signIn(T dto);
}
