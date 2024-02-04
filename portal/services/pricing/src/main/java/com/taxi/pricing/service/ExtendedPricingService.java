package com.taxi.pricing.service;

import com.taxi.framework.pricing.service.AbstractPricingServiceImpl;
import com.taxi.pricing.dto.ExtendedBasePricingDto;
import com.taxi.pricing.dto.ExtendedBaseResponsePricingDto;
import org.springframework.stereotype.Service;

@Service
public class ExtendedPricingService extends AbstractPricingServiceImpl<ExtendedBasePricingDto, ExtendedBaseResponsePricingDto> {
    @Override
    protected ExtendedBaseResponsePricingDto createResponseDto() {
        return new ExtendedBaseResponsePricingDto();
    }
}
