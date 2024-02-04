package com.taxi.framework.pricing.service;

import com.taxi.framework.pricing.dto.BasePricingDTO;
import com.taxi.framework.pricing.dto.BaseResponsePricingDTO;
import com.taxi.framework.utils.Utilities;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public abstract class AbstractPricingServiceImpl<T extends BasePricingDTO, Y extends BaseResponsePricingDTO>  implements PricingService<T, Y>, Utilities {

    public Y getResponse(T dto){
        Y baseResponsePricingDTO = createResponseDto();
        baseResponsePricingDTO.setTravelPrice(calculateTravelCost(dto));
        baseResponsePricingDTO.setUserId(dto.getUserId());
        return baseResponsePricingDTO;
    }

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
        if (basePricingDTO.isRainy())
            cost *= checkRainyCost();
        else if (basePricingDTO.isSnowy())
            cost *= checkSnowyCost();
        if (!basePricingDTO.getOffCode().equals("")){
            cost = offPrice(basePricingDTO.getOffCode());
        }
        return cost;
    }

    @Override
    public double offPrice(String code) {
        return 0;
    }

    @Override
    public double checkRainyCost() {
        return 1.2;
    }

    @Override
    public double checkSnowyCost() {
        return 1.3;
    }

    protected abstract Y createResponseDto();

}
