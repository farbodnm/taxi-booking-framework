package com.taxi.framework.user.controller;

import com.taxi.framework.user.service.SignupService;
import com.taxi.framework.user.dto.BaseUserSignupDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public abstract class AbstractSignupController<T extends BaseUserSignupDTO> {

    protected final SignupService<T> signupService;

    protected AbstractSignupController(SignupService<T> signupService) {
        this.signupService = signupService;
    }

    @PostMapping("/signup")
    public ResponseEntity<T> signUp(@RequestBody T dto) {
        return ResponseEntity.ok(signupService.signUp(dto));
    }
}
