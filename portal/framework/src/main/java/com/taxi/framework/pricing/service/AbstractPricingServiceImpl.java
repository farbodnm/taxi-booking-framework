package com.taxi.framework.pricing.service;

import com.taxi.framework.pricing.dto.BasePricingDTO;
import com.taxi.framework.pricing.dto.BaseResponsePricingDTO;
import com.taxi.framework.utils.Utilities;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public abstract class AbstractPricingServiceImpl<T extends BasePricingDTO, Y extends BaseResponsePricingDTO>  implements PricingService<T, Y>, Utilities {

    @Override
    public double calculateTravelCost(T basePricingDTO) {
        double cost = 0.0;
        double dist = Utilities.calculateDistance(
                basePricingDTO.getLatitude(),
                basePricingDTO.getLongitude(),
                basePricingDTO.getDestLatitude(),
                basePricingDTO.getDestLongitude()
        );
        cost = dist*basePricingDTO.getPricePerMeter();
        cost *= basePricingDTO.getHeavy();
        if (basePricingDTO.getIsRainy())
            cost *= checkRainyCost();
        else if (basePricingDTO.getIsSnowy())
            cost *= checkSnowyCost();
        if (!basePricingDTO.getOffCode().equals("")){
            cost = offPrice(basePricingDTO.getOffCode(), cost);
        }
        return cost;
    }
}
