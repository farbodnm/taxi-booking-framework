package com.taxi.framework.pricing.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BaseResponsePricingDTO {
    private long userId;
    private double travelPrice;
}
