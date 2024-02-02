package com.taxi.framework.booking.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BaseBookedRequestDTO {
    private long driverId;
    private float driverLongitude;
    private float driverLatitude;
}
