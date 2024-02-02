package com.taxi.framework.dispatch.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BaseDriverDTO {
    private long driverId;
    private float driverLongitude;
    private float driverLatitude;
    private String message;
}
