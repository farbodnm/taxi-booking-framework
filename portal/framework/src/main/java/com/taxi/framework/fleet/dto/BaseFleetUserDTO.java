package com.taxi.framework.fleet.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BaseFleetUserDTO {
    private long userId;
    private float longitude;
    private float latitude;
    private float destLongitude;
    private float destLatitude;
}
