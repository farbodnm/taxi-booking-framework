package com.taxi.framework.user.controller;

import com.taxi.framework.user.service.SignupService;
import com.taxi.framework.user.dto.BaseUserSignupDTO;

public abstract class AbstractSignupController<T extends BaseUserSignupDTO> {

    protected final SignupService<T> signupService;

    protected AbstractSignupController(SignupService<T> signupService) {
        this.signupService = signupService;
    }
}
