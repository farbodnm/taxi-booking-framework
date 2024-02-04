package com.taxi.framework.fleet.controller;

import com.taxi.framework.fleet.dto.BaseFleetDriverDTO;
import com.taxi.framework.fleet.dto.BaseFleetUserDTO;
import com.taxi.framework.fleet.service.FleetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Set;

public abstract class AbstractFleetController<T extends BaseFleetUserDTO, Y extends BaseFleetDriverDTO> {

    protected final FleetService<T, Y> fleetService;

    protected AbstractFleetController(FleetService<T, Y> fleetService) {
        this.fleetService = fleetService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerDriver(@RequestBody Y driverDTO) {
        return ResponseEntity.ok(fleetService.registerDriver(driverDTO));
    }

    @PostMapping("/location/update")
    public ResponseEntity<String> updateDriverLoc(@RequestBody Y driverDTO) {
        return ResponseEntity.ok(fleetService.updateDriverLoc(driverDTO));
    }

    @PostMapping("/location/{driverId}")
    public ResponseEntity<Y> getDriverLoc(@PathVariable long driverId) {
        return ResponseEntity.ok(fleetService.getDriverLoc(driverId));
    }

    @GetMapping("/refresh/{driverId}")
    public ResponseEntity<Set<T>> refresh(@PathVariable long driverId) {
        return ResponseEntity.ok(fleetService.refresh(driverId));
    }

    @PostMapping("/accept/{userId}")
    public ResponseEntity<T> accept(@PathVariable long userId, @RequestBody Y driverDTO) {
        return ResponseEntity.ok(fleetService.acceptUser(userId, driverDTO));
    }

    @PostMapping("/update/{driverId}")
    public void update(@PathVariable long driverId, @RequestBody T user) {
        fleetService.updateNearbyUsers(driverId, user);
    }
}
