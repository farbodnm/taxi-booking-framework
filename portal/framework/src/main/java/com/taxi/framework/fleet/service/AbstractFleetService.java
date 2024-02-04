package com.taxi.framework.fleet.service;

import com.taxi.framework.fleet.dto.BaseFleetDriverDTO;
import com.taxi.framework.fleet.dto.BaseFleetUserDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AbstractFleetService<T extends BaseFleetUserDTO, Y extends BaseFleetDriverDTO>  implements FleetService<T, Y> {

    private Map<Long, Y> drivers = new HashMap<>();

    private Map<Long, Set<T>> nearbyUsers = new HashMap<>();

    private final String dispatchEndpoint;

    protected AbstractFleetService(String dispatchEndpoint) {
        this.dispatchEndpoint = dispatchEndpoint;
    }

    @Override
    public String registerDriver(Y driverDTO) {

        String url = dispatchEndpoint + "/dispatch/find/users";
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Set<T>> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.POST,
                new HttpEntity<>(driverDTO),
                new ParameterizedTypeReference<Set<T>>() {
                }
        );

        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            Set<T> users = responseEntity.getBody();
            nearbyUsers.put(driverDTO.getDriverId(), users);
            drivers.put(driverDTO.getDriverId(), driverDTO);
            return "Registration request successful.";
        } else {
            return "Registration request failed.";
        }
    }

    @Override
    public String updateDriverLoc(Y driverDTO) {
        if (drivers.get(driverDTO.getDriverId()) != null) {
            drivers.put(driverDTO.getDriverId(), driverDTO);
            return "Location updated successfully.";
        }
        return "The driver is not registered as looking for a user.";
    }

    @Override
    public Set<T> refresh(long driverId) {
        Set<T> users = nearbyUsers.get(driverId);
        return users;
    }

    @Override
    public Y getDriverLoc(long driverId) {
        return drivers.get(driverId);
    }

    @Override
    public T acceptUser(Long userId, Y driverDTO) {
        String url = dispatchEndpoint + "/dispatch/accept/" + userId.toString();
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<T> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.POST,
                new HttpEntity<>(driverDTO),
                new ParameterizedTypeReference<T>() {
                }
        );

        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            T user = responseEntity.getBody();
            nearbyUsers.remove(driverDTO.getDriverId());
            drivers.remove(driverDTO.getDriverId());
            return user;
        } else {
            return null;
        }
    }

    @Override
    public void updateNearbyUsers(long driverId, T userDTO) {
        Set<T> users = nearbyUsers.get(driverId);
        if (users != null) {
            users.add(userDTO);
        }
        nearbyUsers.put(driverId, users);
    }
}
