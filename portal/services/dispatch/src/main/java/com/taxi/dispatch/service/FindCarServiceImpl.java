package com.taxi.dispatch.service;

import com.taxi.framework.dispatch.dto.BaseDriverDTO;
import com.taxi.framework.dispatch.dto.BaseUserDTO;
import com.taxi.framework.dispatch.service.AbstractFindCarService;
import org.springframework.stereotype.Service;

@Service
public class FindCarServiceImpl extends AbstractFindCarService<BaseUserDTO, BaseDriverDTO> {
}
