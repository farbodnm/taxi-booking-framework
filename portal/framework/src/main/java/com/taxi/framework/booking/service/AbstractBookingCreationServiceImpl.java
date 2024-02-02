package com.taxi.framework.booking.service;

import com.taxi.framework.booking.dto.BaseBookedRequestDTO;
import com.taxi.framework.booking.dto.BaseBookingRequestDTO;

public abstract class AbstractBookingCreationServiceImpl implements BookingCreationService<BaseBookingRequestDTO, BaseBookedRequestDTO> {

    @Override
    public BaseBookingRequestDTO createBooking(BaseBookingRequestDTO baseBookingRequestDTO) {
        return baseBookingRequestDTO;
    }

    @Override
    public BaseBookedRequestDTO booked(BaseBookedRequestDTO baseBookedRequestDTO) {
        return baseBookedRequestDTO;
    }

    @Override
    public String refresh(){
        return "Booking successful";
    }
}
