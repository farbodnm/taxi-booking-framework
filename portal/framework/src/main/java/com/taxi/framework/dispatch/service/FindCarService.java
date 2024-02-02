package com.taxi.framework.dispatch.service;

import com.taxi.framework.dispatch.dto.BaseDriverDTO;
import com.taxi.framework.dispatch.dto.BaseUserDTO;

import java.util.Set;

public interface FindCarService<T extends BaseUserDTO, Y extends BaseDriverDTO>{
    Set<Y> findDriver(T t);
    Set<T> findUser(Y y);
    T acceptUser(Y y, Long userId);
}
