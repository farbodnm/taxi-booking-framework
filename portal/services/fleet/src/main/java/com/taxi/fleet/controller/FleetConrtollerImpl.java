package com.taxi.fleet.controller;

import com.taxi.fleet.service.FleetServiceImpl;
import com.taxi.framework.fleet.controller.AbstractFleetController;
import com.taxi.framework.fleet.dto.BaseFleetDriverDTO;
import com.taxi.framework.fleet.dto.BaseFleetUserDTO;
import com.taxi.framework.fleet.service.FleetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/fleet")
@RestController
public class FleetConrtollerImpl extends AbstractFleetController<BaseFleetUserDTO, BaseFleetDriverDTO> {

    @Autowired
    private FleetServiceImpl fleetService;

    protected FleetConrtollerImpl(FleetServiceImpl fleetService) {
        super(fleetService);
    }
}
