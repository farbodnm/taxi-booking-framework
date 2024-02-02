package com.taxi.user.controller;

import com.taxi.framework.user.controller.AbstractSignupController;
import com.taxi.framework.user.dto.BaseUserSignupDTO;
import com.taxi.user.service.SignupServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/user")
@RestController
public class SignupControllerImplement extends AbstractSignupController<BaseUserSignupDTO> {

    @Autowired
    private SignupServiceImpl signupService;

    protected SignupControllerImplement(SignupServiceImpl signupService) {
        super(signupService);
    }
}
