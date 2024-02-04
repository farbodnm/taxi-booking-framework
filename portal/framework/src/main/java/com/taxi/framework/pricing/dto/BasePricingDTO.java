package com.taxi.framework.pricing.dto;


import com.taxi.framework.fleet.dto.BaseFleetUserDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class BasePricingDTO extends BaseFleetUserDTO {
    private float pricePerMeter;
    private float heavy;
    private Boolean isRainy;
    private Boolean isSnowy;
    private String offCode;
}
