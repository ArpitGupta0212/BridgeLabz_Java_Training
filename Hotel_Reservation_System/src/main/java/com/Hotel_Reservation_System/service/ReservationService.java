package com.Hotel_Reservation_System.service;

import com.Hotel_Reservation_System.model.Reservation;
import com.Hotel_Reservation_System.model.Room;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReservationService {
    private final List<Room> rooms = new ArrayList<>();

    private final Map<String, List<Reservation>> bookingsByDate = new HashMap<>();

    private final Map<String, Double> revenueByRoomType = new HashMap<>();

    public void loadRooms(List<Room> inputRooms) {

        rooms.clear();
        rooms.addAll(inputRooms);
    }

    public List<Room> findAvailableRooms(String type, double maxPrice) {

        return rooms.stream().filter(r -> r.isAvailable() && r.getType().equalsIgnoreCase(type) && r.getPricePerNight() <= maxPrice).collect(Collectors.toList());
    }

    public void addBooking(String date, Reservation reservation) {

        bookingsByDate.computeIfAbsent(date, k -> new ArrayList<>()).add(reservation);
    }

    public void trackRevenue(String roomType, double amount) {

        revenueByRoomType.merge(roomType, amount, Double::sum);
    }

    public void evictCancelledBookings() {

        bookingsByDate.values().forEach(list -> list.removeIf(r -> "Cancelled".equalsIgnoreCase(r.getStatus())));
    }

    public double calculateTotalRevenue() {

        return revenueByRoomType.values().stream().mapToDouble(Double::doubleValue).sum();
    }
}
