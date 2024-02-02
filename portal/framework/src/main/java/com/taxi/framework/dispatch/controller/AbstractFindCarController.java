package com.taxi.framework.dispatch.controller;

import com.taxi.framework.booking.dto.BaseBookedRequestDTO;
import com.taxi.framework.booking.dto.BaseBookingRequestDTO;
import com.taxi.framework.dispatch.dto.BaseDriverDTO;
import com.taxi.framework.dispatch.dto.BaseUserDTO;
import com.taxi.framework.dispatch.service.FindCarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Set;

public abstract class AbstractFindCarController<T extends BaseUserDTO, Y extends BaseDriverDTO> {
    protected final FindCarService<T, Y> findCarService;

    protected AbstractFindCarController(FindCarService<T, Y> findCarService) {
        this.findCarService = findCarService;
    }

    @PostMapping("/find/driver")
    public ResponseEntity<Set<Y>> findDriver(@RequestBody T dto) {
        return ResponseEntity.ok(findCarService.findDriver(dto));
    }

    @PostMapping("/find/users")
    public ResponseEntity<Set<T>> findUsers(@RequestBody Y dto) {
        return ResponseEntity.ok(findCarService.findUser(dto));
    }

    @PostMapping("/accept/{userId}")
    public ResponseEntity<T> acceptUser(@PathVariable long userId, @RequestBody Y dto) {
        return ResponseEntity.ok(findCarService.acceptUser(dto, userId));
    }
}
