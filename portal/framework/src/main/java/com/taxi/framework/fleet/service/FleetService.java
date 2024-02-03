package com.taxi.framework.fleet.service;

import com.taxi.framework.dispatch.dto.BaseDriverDTO;
import com.taxi.framework.dispatch.dto.BaseUserDTO;
import com.taxi.framework.fleet.dto.BaseFleetDriverDTO;
import com.taxi.framework.fleet.dto.BaseFleetUserDTO;

import java.util.Set;

public interface FleetService<T extends BaseFleetUserDTO, Y extends BaseFleetDriverDTO> {
    String registerDriver(Y driverDTO);
    String updateDriverLoc(Y driverDTO);
    Set<T> refresh(long driverId);
    Y getDriverLoc(long driverId);
    T acceptUser(Long userId, Y driverDTO);
    void updateNearbyUsers(long driverId, T userDTO);
}
