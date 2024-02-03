package com.taxi.framework.booking.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BaseBookedRequestDTO {
    private long driverId;
    private float driverLongitude;
    private float driverLatitude;
    private MessageEnum message;

    @Getter
    public enum MessageEnum {
        LOOKING_FOR_A_DRIVER("We are looking for a driver for you."),
        DRIVER_ON_THE_WAY("Your driver is on the way."),
        DRIVER_ARRIVED("Your driver has arrived"),
        USER_IN_CAR("You are in the car."),
        REACHED_DESTINATION("You have reached your destination.");

        private final String message;

        MessageEnum(String message) {
            this.message = message;
        }

        public MessageEnum getNextState() {

            if (this == REACHED_DESTINATION) {
                return this;
            }

            int nextIndex = (this.ordinal() + 1) % values().length;
            return values()[nextIndex];
        }
    }
}
