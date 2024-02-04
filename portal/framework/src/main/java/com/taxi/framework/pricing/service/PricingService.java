package com.taxi.framework.pricing.service;

import com.taxi.framework.pricing.dto.BasePricingDTO;
import com.taxi.framework.pricing.dto.BaseResponsePricingDTO;

public interface PricingService <T extends BasePricingDTO, Y extends BaseResponsePricingDTO> {
    double calculateTravelCost(T basePricingDTO);
    Y getResponse(T dto);

    double offPrice(String code, double price);
    double checkRainyCost();
    double checkSnowyCost();
}
