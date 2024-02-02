package com.taxi.framework.user.service;

import com.taxi.framework.user.dto.BaseUserSignupDTO;

public interface SignupService<T extends BaseUserSignupDTO> {
    T signUp(T dto);
}
