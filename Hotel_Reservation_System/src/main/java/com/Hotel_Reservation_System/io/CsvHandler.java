package com.Hotel_Reservation_System.io;

import com.Hotel_Reservation_System.model.Room;
import com.Hotel_Reservation_System.validation.RoomValidator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class CsvHandler {
    public static List<Room> readRoomsFromCsv(String filePath) {

        List<Room> rooms = new ArrayList<>();

        RoomValidator validator = new RoomValidator();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            String line;

            reader.readLine();

            while ((line = reader.readLine()) != null) {

                try {

                    String[] data = line.split(",");

                    Room room = new Room(Integer.parseInt(data[0]), data[1], Double.parseDouble(data[2]), Boolean.parseBoolean(data[3]));

                    List<String> errors = validator.validate(room);

                    if (errors.isEmpty()) {

                        rooms.add(room);

                    } else {

                        System.out.println("Invalid Room -> " + room);

                        System.out.println(errors);
                    }

                } catch (NumberFormatException e) {

                    System.out.println("Skipping Invalid Row : " + line);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rooms;
    }

    public static void writeRoomsToCsv(String filePath, List<Room> rooms) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {

            writer.write("RoomNumber,Type,PricePerNight,IsAvailable");

            writer.newLine();

            for (Room room : rooms) {

                writer.write(room.getRoomNumber() + "," + room.getType() + "," + room.getPricePerNight() + "," + room.isAvailable());

                writer.newLine();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
