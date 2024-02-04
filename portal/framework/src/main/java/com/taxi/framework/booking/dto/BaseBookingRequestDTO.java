package com.taxi.framework.booking.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BaseBookingRequestDTO {
    private long userId;
    private float longitude;
    private float latitude;
    private float destLongitude;
    private float destLatitude;
    private float price;
}
