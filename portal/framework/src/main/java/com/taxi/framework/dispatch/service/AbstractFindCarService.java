package com.taxi.framework.dispatch.service;

import com.taxi.framework.dispatch.dto.BaseDriverDTO;
import com.taxi.framework.dispatch.dto.BaseUserDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractFindCarService<U extends BaseUserDTO, D extends BaseDriverDTO> implements FindCarService<U, D> {

    private Map<Long, U> usersMap = new HashMap<>();
    private Map<Long, D> driversMap = new HashMap<>();

    @Override
    public Set<D> findDriver(U userDTO) {
        long userId = userDTO.getUserId();
        usersMap.put(userId, userDTO);
        return findNearbyDrivers(userDTO);
    }

    @Override
    public Set<U> findUser(D driverDTO) {
        long driverId = driverDTO.getDriverId();
        driversMap.put(driverId, driverDTO);
        return findNearbyUsers(driverDTO);
    }

    @Override
    public String acceptUser(D driverDTO, Long userId){
        long driverId = driverDTO.getDriverId();

        U userDTO = usersMap.get(userId);

        String url = "http://localhost:10001/api/booking/booked/" + userId.toString();
        RestTemplate restTemplate = new RestTemplate();

        if (restTemplate.exchange(
                url,
                HttpMethod.POST,
                new HttpEntity<>(driverDTO),
                Void.class
        ).getStatusCode() == HttpStatusCode.valueOf(200)) {
            usersMap.remove(userId);
            driversMap.remove(driverId);
            return "Acceptance request sent successfully.";
        }
        return "Acceptance request failed.";
    }

    private Set<U> findNearbyUsers(D driverDTO) {

        float driverLatitude = driverDTO.getDriverLatitude();
        float driverLongitude = driverDTO.getDriverLongitude();

        Set<U> nearbyUsers = new HashSet<>();

        for (U user : usersMap.values()) {
            if (calculateDistance(
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
            if (calculateDistance(
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

    private double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371; // Radius of the earth

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return R * c;
    }
}
