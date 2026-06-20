package com.Hotel_Reservation_System.validation;

import com.Hotel_Reservation_System.model.Room;

import java.util.ArrayList;
import java.util.List;

public class RoomValidator implements Validator<Room> {
    public List<String> validate(Room room) {

        List<String> errors = new ArrayList<>();

        if (room.getRoomNumber() <= 0) {
            errors.add("Room Number must be positive");
        }

        if (room.getPricePerNight() <= 0) {
            errors.add("Price must be positive");
        }

        String type = room.getType();

        if (type == null || !(type.equalsIgnoreCase("Single") || type.equalsIgnoreCase("Double") || type.equalsIgnoreCase("Suite"))) {

            errors.add("Invalid room type");
        }

        return errors;
    }
}
