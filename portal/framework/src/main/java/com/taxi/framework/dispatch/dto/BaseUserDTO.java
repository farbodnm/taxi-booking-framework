package com.taxi.framework.dispatch.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BaseUserDTO {
    private long userId;
    private float longitude;
    private float latitude;
    private float destLongitude;
    private float destLatitude;
    private String message;
}
