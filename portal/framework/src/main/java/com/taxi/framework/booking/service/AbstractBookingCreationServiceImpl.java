package com.taxi.framework.booking.service;

import com.taxi.framework.booking.dto.BaseBookedRequestDTO;
import com.taxi.framework.booking.dto.BaseBookingRequestDTO;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractBookingCreationServiceImpl implements BookingCreationService<BaseBookingRequestDTO, BaseBookedRequestDTO> {

    private Map<Long, BaseBookedRequestDTO> assignedDriversMap = new HashMap<>();

    @Override
    public String createBooking(BaseBookingRequestDTO baseBookingRequestDTO) {
        String url = "http://localhost:10002/api/dispatch/find/driver";
        RestTemplate restTemplate = new RestTemplate();
        if (restTemplate.exchange(
                url,
                HttpMethod.POST,
                new HttpEntity<>(baseBookingRequestDTO),
                Void.class
        ).getStatusCode() == HttpStatusCode.valueOf(200)) {

            BaseBookedRequestDTO bookedRequest = new BaseBookedRequestDTO();
            bookedRequest.setMessage("Trying to find you a driver");
            assignedDriversMap.put(baseBookingRequestDTO.getUserId(), bookedRequest);

            return "Booking request successful.";
        }
        return "Booking request failed";
    }

    @Override
    public BaseBookedRequestDTO booked(BaseBookedRequestDTO baseBookedRequestDTO, long userId) {

        assignedDriversMap.put(userId, baseBookedRequestDTO);

        return baseBookedRequestDTO;
    }

    @Override
    public BaseBookedRequestDTO refresh(long userId){
        return assignedDriversMap.get(userId);
    }
}
