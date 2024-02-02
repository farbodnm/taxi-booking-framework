package com.taxi.framework.booking.controller;

import com.taxi.framework.booking.dto.BaseBookedRequestDTO;
import com.taxi.framework.booking.dto.BaseBookingRequestDTO;
import com.taxi.framework.booking.service.BookingCreationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public abstract class AbstractBookingController<T extends BaseBookingRequestDTO, Y extends BaseBookedRequestDTO> {
    protected final BookingCreationService<T, Y> bookingCreationService;

    protected AbstractBookingController(BookingCreationService<T, Y> bookingCreationService) {
        this.bookingCreationService = bookingCreationService;
    }

    @PostMapping("/book")
    public ResponseEntity<T> book(@RequestBody T dto) {
        return ResponseEntity.ok(bookingCreationService.createBooking(dto));
    }

    @PostMapping("/booked")
    public ResponseEntity<Y> booked(@RequestBody Y dto) {
        return ResponseEntity.ok(bookingCreationService.booked(dto));
    }

    @GetMapping("/refresh")
    public ResponseEntity<String> refresh() {
        return ResponseEntity.ok(bookingCreationService.refresh());
    }
}
