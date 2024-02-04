package com.taxi.framework.dispatch.service;

import com.taxi.framework.dispatch.dto.BaseDriverDTO;
import com.taxi.framework.dispatch.dto.BaseUserDTO;
import com.taxi.framework.utils.Utilities;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public abstract class AbstractFindCarService<U extends BaseUserDTO, D extends BaseDriverDTO> implements FindCarService<U, D> {

    private Map<Long, U> usersMap = new HashMap<>();
    private Map<Long, D> driversMap = new HashMap<>();

    private final String fleetEndpoint;
    private final String bookingEndpoint;

    protected AbstractFindCarService(String fleetEndpoint, String bookingEndpoint) {
        this.fleetEndpoint = fleetEndpoint;
        this.bookingEndpoint = bookingEndpoint;
    }


    @Override
    public Set<D> findDriver(U userDTO) {
        long userId = userDTO.getUserId();
        Map<Long, D> tempDriversMap = driversMap;
        for (D driver : tempDriversMap.values()) {
            String url = fleetEndpoint + "/fleet/location/" + driver.getDriverId();
            RestTemplate restTemplate = new RestTemplate();

            ResponseEntity<D> responseEntity = restTemplate.exchange(
                    url,
                    HttpMethod.POST,
                    null,
                    new ParameterizedTypeReference<D>() {
                    }
            );

            if (responseEntity.getStatusCode() == HttpStatus.OK) {
                D theDriver = responseEntity.getBody();
                assert theDriver != null;
                driversMap.put(theDriver.getDriverId(), theDriver);
            }
        }
        usersMap.put(userId, userDTO);
        Set<D> nearbyDrivers = findNearbyDrivers(userDTO);
        for (D nearbyDriver: nearbyDrivers) {
            String url = fleetEndpoint + "/fleet/update/" + nearbyDriver.getDriverId();
            RestTemplate restTemplate = new RestTemplate();

            if (restTemplate.exchange(
                    url,
                    HttpMethod.POST,
                    new HttpEntity<>(userDTO),
                    Void.class
            ).getStatusCode() == HttpStatusCode.valueOf(200));
        }
        return nearbyDrivers;
    }

    @Override
    public Set<U> findUser(D driverDTO) {
        long driverId = driverDTO.getDriverId();
        Map<Long, D> tempDriversMap = driversMap;
        for (D driver : tempDriversMap.values()) {
            String url = fleetEndpoint + "/fleet/location/" + driver.getDriverId();
            RestTemplate restTemplate = new RestTemplate();

            ResponseEntity<D> responseEntity = restTemplate.exchange(
                    url,
                    HttpMethod.POST,
                    null,
                    new ParameterizedTypeReference<D>() {
                    }
            );

            if (responseEntity.getStatusCode() == HttpStatus.OK) {
                D theDriver = responseEntity.getBody();
                assert theDriver != null;
                driversMap.put(theDriver.getDriverId(), theDriver);
            }
        }
        driversMap.put(driverId, driverDTO);
        return findNearbyUsers(driverDTO);
    }

    @Override
    public U acceptUser(D driverDTO, Long userId){
        long driverId = driverDTO.getDriverId();

        String url = bookingEndpoint + "/booking/booked/" + userId.toString();
        RestTemplate restTemplate = new RestTemplate();

        if (restTemplate.exchange(
                url,
                HttpMethod.POST,
                new HttpEntity<>(driverDTO),
                Void.class
        ).getStatusCode() == HttpStatusCode.valueOf(200)) {
            U userDTO = usersMap.get(userId);
            usersMap.remove(userId);
            driversMap.remove(driverId);
            return userDTO;
        }
        return null;
    }

    private Set<U> findNearbyUsers(D driverDTO) {

        float driverLatitude = driverDTO.getDriverLatitude();
        float driverLongitude = driverDTO.getDriverLongitude();

        Set<U> nearbyUsers = new HashSet<>();

        for (U user : usersMap.values()) {
            if (Utilities.calculateDistance(
                    driverLatitude,
                    driverLongitude,
                    user.getLatitude(),
                    user.getLongitude()
            ) <= 100.0) {
                nearbyUsers.add(user);
            }
        }

        return nearbyUsers;
    }

    private Set<D> findNearbyDrivers(U userDTO) {

        float userLatitude = userDTO.getLatitude();
        float userLongitude = userDTO.getLongitude();

        Set<D> nearbyDrivers = new HashSet<>();

        for (D driver : driversMap.values()) {
            if (Utilities.calculateDistance(
                    userLatitude,
                    userLongitude,
                    driver.getDriverLatitude(),
                    driver.getDriverLongitude()
            ) <= 100.0) {
                nearbyDrivers.add(driver);
            }
        }

        return nearbyDrivers;
    }


}
