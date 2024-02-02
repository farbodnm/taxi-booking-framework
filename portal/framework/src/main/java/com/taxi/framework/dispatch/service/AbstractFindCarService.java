package com.taxi.framework.dispatch.service;

import com.taxi.framework.dispatch.dto.BaseDriverDTO;
import com.taxi.framework.dispatch.dto.BaseUserDTO;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AbstractFindCarService implements FindCarService<BaseUserDTO, BaseDriverDTO> {

    private Map<Long, BaseUserDTO> usersMap = new HashMap<>();
    private Map<Long, BaseDriverDTO> driversMap = new HashMap<>();

    @Override
    public Set<BaseDriverDTO> findDriver(BaseUserDTO userDTO) {
        long userId = userDTO.getUserId();
        usersMap.put(userId, userDTO);
        return findNearbyDrivers(userDTO);
    }

    @Override
    public Set<BaseUserDTO> findUser(BaseDriverDTO driverDTO) {
        long driverId = driverDTO.getDriverId();
        driversMap.put(driverId, driverDTO);
        return findNearbyUsers(driverDTO);
    }

    @Override
    public BaseDriverDTO reportFoundDriver(BaseDriverDTO baseBookedRequestDTO) {
        return null;
    }

    @Override
    public BaseUserDTO acceptUser(BaseDriverDTO driverDTO, long userId){
        long driverId = driverDTO.getDriverId();

        BaseUserDTO userDTO = usersMap.get(userId);

        usersMap.remove(userId);
        driversMap.remove(driverId);

        return userDTO;
    }

    private Set<BaseUserDTO> findNearbyUsers(BaseDriverDTO driverDTO) {

        float driverLatitude = driverDTO.getDriverLatitude();
        float driverLongitude = driverDTO.getDriverLongitude();

        Set<BaseUserDTO> nearbyUsers = new HashSet<>();

        for (BaseUserDTO user : usersMap.values()) {
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

    private Set<BaseDriverDTO> findNearbyDrivers(BaseUserDTO userDTO) {

        float userLatitude = userDTO.getLatitude();
        float userLongitude = userDTO.getLongitude();

        Set<BaseDriverDTO> nearbyDrivers = new HashSet<>();

        for (BaseDriverDTO driver : driversMap.values()) {
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
