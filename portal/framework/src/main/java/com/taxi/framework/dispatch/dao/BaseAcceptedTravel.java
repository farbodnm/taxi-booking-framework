package com.taxi.framework.dispatch.dao;

import com.taxi.framework.dispatch.dto.BaseDriverDTO;
import com.taxi.framework.dispatch.dto.BaseUserDTO;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BaseAcceptedTravel<T extends BaseDriverDTO, U extends BaseUserDTO> {
    private T driver;
    private U user;
}
