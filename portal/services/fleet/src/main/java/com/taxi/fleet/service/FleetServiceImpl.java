package com.taxi.fleet.service;

import com.taxi.framework.fleet.dto.BaseFleetDriverDTO;
import com.taxi.framework.fleet.dto.BaseFleetUserDTO;
import com.taxi.framework.fleet.service.AbstractFleetService;
import org.springframework.stereotype.Service;

@Service
public class FleetServiceImpl extends AbstractFleetService<BaseFleetUserDTO, BaseFleetDriverDTO> {

    public FleetServiceImpl() {
        super(
                "http://localhost:10002/api"
        );
    }
}
