package com.taxi.booking.controller;

import com.taxi.booking.service.BookingCreationServiceImpl;
import com.taxi.framework.booking.controller.AbstractBookingController;
import com.taxi.framework.booking.dto.BaseBookedRequestDTO;
import com.taxi.framework.booking.dto.BaseBookingRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/api/booking")
@RestController
public class BookingControllerImpl extends AbstractBookingController<BaseBookingRequestDTO, BaseBookedRequestDTO> {

    @Autowired
    private BookingCreationServiceImpl bookingCreationService;

    protected BookingControllerImpl(BookingCreationServiceImpl bookingCreationService) {
        super(bookingCreationService);
    }
}
