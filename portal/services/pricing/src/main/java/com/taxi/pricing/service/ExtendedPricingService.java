package com.taxi.pricing.service;

import com.taxi.framework.pricing.service.AbstractPricingServiceImpl;
import com.taxi.pricing.dto.ExtendedBasePricingDto;
import com.taxi.pricing.dto.ExtendedBaseResponsePricingDto;
import org.springframework.stereotype.Service;

@Service
public class ExtendedPricingService extends AbstractPricingServiceImpl<ExtendedBasePricingDto, ExtendedBaseResponsePricingDto> {

    @Override
    public ExtendedBaseResponsePricingDto getResponse(ExtendedBasePricingDto dto) {
        ExtendedBaseResponsePricingDto extendedBaseResponsePricingDto = new ExtendedBaseResponsePricingDto();
        extendedBaseResponsePricingDto.setTravelPrice(calculateTravelCost(dto));
        extendedBaseResponsePricingDto.setUserId(dto.getUserId());
        return extendedBaseResponsePricingDto;
    }

    @Override
    public double offPrice(String code, double price) {
        return price;
    }

    @Override
    public double checkRainyCost() {
        return 1.2;
    }

    @Override
    public double checkSnowyCost() {
        return 1.3;
    }
}
