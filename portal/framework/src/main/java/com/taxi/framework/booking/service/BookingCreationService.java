package com.taxi.framework.booking.service;

import com.taxi.framework.booking.dto.BaseBookedRequestDTO;
import com.taxi.framework.booking.dto.BaseBookingRequestDTO;

public interface BookingCreationService<T extends BaseBookingRequestDTO, Y extends BaseBookedRequestDTO> {
    String createBooking(T t);
    Y refresh(long userId);
    Y booked(Y y, long userId);
    String bookingNextState(long userId);
}
