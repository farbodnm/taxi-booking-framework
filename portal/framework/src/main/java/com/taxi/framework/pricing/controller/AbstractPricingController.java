package com.taxi.framework.pricing.controller;

import com.taxi.framework.pricing.dto.BasePricingDTO;
import com.taxi.framework.pricing.dto.BaseResponsePricingDTO;
import com.taxi.framework.pricing.service.AbstractPricingServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;


public abstract class AbstractPricingController<T extends BasePricingDTO, Y extends BaseResponsePricingDTO> {
    protected final AbstractPricingServiceImpl<T, Y> pricingService;
    private final Map<Long, Y> response = new HashMap<>();

    protected AbstractPricingController(AbstractPricingServiceImpl<T, Y> pricingService) {
        this.pricingService = pricingService;
    }

    @PostMapping(value = "/calculate", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Y> calculatePricing(@RequestBody T dto) {
        return ResponseEntity.ok(pricingService.getResponse(dto));
    }
}
