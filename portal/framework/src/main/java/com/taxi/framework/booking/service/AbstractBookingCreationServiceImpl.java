package com.taxi.framework.booking.service;

import com.taxi.framework.booking.dto.BaseBookedRequestDTO;
import com.taxi.framework.booking.dto.BaseBookingRequestDTO;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractBookingCreationServiceImpl<B extends BaseBookingRequestDTO, R extends BaseBookedRequestDTO> implements BookingCreationService<B, R> {

    private Map<Long, R> assignedDriversMap = new HashMap<>();

    @Override
    public String createBooking(B bookingRequestDTO) {
        String url = "http://localhost:10002/api/dispatch/find/driver";
        RestTemplate restTemplate = new RestTemplate();
        if (restTemplate.exchange(
                url,
                HttpMethod.POST,
                new HttpEntity<>(bookingRequestDTO),
                Void.class
        ).getStatusCode() == HttpStatusCode.valueOf(200)) {

            R bookedRequest = createBookedRequestDTO();
            bookedRequest.setMessage("Trying to find you a driver");
            assignedDriversMap.put(bookingRequestDTO.getUserId(), bookedRequest);

            return "Booking request successful.";
        }
        return "Booking request failed";
    }

    @Override
    public R booked(R bookedRequestDTO, long userId) {

        assignedDriversMap.put(userId, bookedRequestDTO);

        return bookedRequestDTO;
    }

    @Override
    public R refresh(long userId){
        return assignedDriversMap.get(userId);
    }

    // Method to create a new instance of the booked request DTO
    protected abstract R createBookedRequestDTO();
}
