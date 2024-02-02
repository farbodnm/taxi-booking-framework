package com.taxi.framework.user.controller;

import com.taxi.framework.user.dto.BaseUserSigninDTO;
import com.taxi.framework.user.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


public abstract class AbstractAuthController<T extends BaseUserSigninDTO> {

    protected final AuthService<T> authService;

    protected AbstractAuthController(AuthService<T> service) {
        this.authService = service;
    }

    @PostMapping("/signin")
    public ResponseEntity<T> signIn(@RequestBody T dto) {
        return ResponseEntity.ok(authService.signIn(dto));
    }
}
