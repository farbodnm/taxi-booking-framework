package com.taxi.user.framework.service;

import com.taxi.user.framework.dto.BaseUserSigninDTO;


public interface AuthService<T extends BaseUserSigninDTO> {
    T signIn(T dto);
}
