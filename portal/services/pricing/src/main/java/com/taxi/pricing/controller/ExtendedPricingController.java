package com.taxi.pricing.controller;

import com.taxi.framework.pricing.controller.AbstractPricingController;
import com.taxi.framework.pricing.service.AbstractPricingServiceImpl;
import com.taxi.pricing.dto.ExtendedBasePricingDto;
import com.taxi.pricing.dto.ExtendedBaseResponsePricingDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/pricing")
@RestController
public class ExtendedPricingController extends AbstractPricingController<ExtendedBasePricingDto, ExtendedBaseResponsePricingDto> {

    protected ExtendedPricingController(AbstractPricingServiceImpl<ExtendedBasePricingDto, ExtendedBaseResponsePricingDto> pricingService) {
        super(pricingService);
    }
}
