package com.taxi.framework.booking.service;

import com.taxi.framework.booking.dto.BaseBookedRequestDTO;
import com.taxi.framework.booking.dto.BaseBookingRequestDTO;

public interface BookingCreationService<T extends BaseBookingRequestDTO, Y extends BaseBookedRequestDTO> {
    T createBooking(T t);
    String refresh();
    Y booked(Y y);
}
