package com.taxi.framework.booking.controller;

import com.taxi.framework.booking.dto.BaseBookedRequestDTO;
import com.taxi.framework.booking.dto.BaseBookingRequestDTO;
import com.taxi.framework.booking.service.BookingCreationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public abstract class AbstractBookingController<T extends BaseBookingRequestDTO, Y extends BaseBookedRequestDTO> {
    protected final BookingCreationService<T, Y> bookingCreationService;

    protected AbstractBookingController(BookingCreationService<T, Y> bookingCreationService) {
        this.bookingCreationService = bookingCreationService;
    }

    @PostMapping("/book")
    public ResponseEntity<String> book(@RequestBody T dto) {
        return ResponseEntity.ok(bookingCreationService.createBooking(dto));
    }

    @PostMapping("/booked/{userId}")
    public ResponseEntity<Y> booked(@RequestBody Y dto, @PathVariable long userId) {
        return ResponseEntity.ok(bookingCreationService.booked(dto, userId));
    }

    @GetMapping("/refresh/{userId}")
    public ResponseEntity<BaseBookedRequestDTO> refresh(@PathVariable long userId) {
        return ResponseEntity.ok(bookingCreationService.refresh(userId));
    }
}
