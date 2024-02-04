package com.taxi.framework.pricing.dto;


import com.taxi.framework.fleet.dto.BaseFleetUserDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class BasePricingDTO extends BaseFleetUserDTO {
    float pricePerMeter;
    float heavy;
    boolean isRainy;
    boolean isSnowy;
    String offCode;
}
