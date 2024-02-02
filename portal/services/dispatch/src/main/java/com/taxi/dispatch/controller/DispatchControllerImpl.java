package com.taxi.dispatch.controller;

import com.taxi.dispatch.service.FindCarServiceImpl;
import com.taxi.framework.dispatch.controller.AbstractFindCarController;
import com.taxi.framework.dispatch.dto.BaseDriverDTO;
import com.taxi.framework.dispatch.dto.BaseUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/dispatch")
@RestController
public class DispatchControllerImpl extends AbstractFindCarController<BaseUserDTO, BaseDriverDTO> {

    @Autowired
    private FindCarServiceImpl findCarService;

    protected DispatchControllerImpl(FindCarServiceImpl findCarService) {
        super(findCarService);
    }
}
