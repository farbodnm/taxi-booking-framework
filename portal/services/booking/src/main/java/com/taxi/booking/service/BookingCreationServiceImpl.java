package com.taxi.booking.service;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.taxi.framework.booking.dto.BaseBookedRequestDTO;
import com.taxi.framework.booking.dto.BaseBookingRequestDTO;
import com.taxi.framework.booking.service.AbstractBookingCreationServiceImpl;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
public class BookingCreationServiceImpl extends AbstractBookingCreationServiceImpl<BaseBookingRequestDTO, BaseBookedRequestDTO> {

    public BookingCreationServiceImpl() {
        super(
                "http://localhost:10002/api"
        );
    }

    @Override
    protected BaseBookedRequestDTO createBookedRequestDTO() {
        return new BaseBookedRequestDTO();
    }
}
