package com.taxi.framework.fleet.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BaseFleetDriverDTO {
    private long driverId;
    private float driverLongitude;
    private float driverLatitude;
}
