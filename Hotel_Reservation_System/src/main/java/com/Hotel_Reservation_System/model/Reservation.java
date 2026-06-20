package com.Hotel_Reservation_System.model;

public class Reservation {
    private String reservationId;
    private String guestName;
    private int roomNumber;
    private int nights;
    private double totalAmount;
    private String status;

    public Reservation() {
    }

    public Reservation(String reservationId, String guestName, int roomNumber, int nights, double totalAmount, String status) {

        this.reservationId = reservationId;
        this.guestName = guestName;
        this.roomNumber = roomNumber;
        this.nights = nights;
        this.totalAmount = totalAmount;
        this.status = status;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getNights() {
        return nights;
    }

    public void setNights(int nights) {
        this.nights = nights;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Reservation{" + "reservationId='" + reservationId + '\'' + ", guestName='" + guestName + '\'' + ", roomNumber=" + roomNumber + ", nights=" + nights + ", totalAmount=" + totalAmount + ", status='" + status + '\'' + '}';
    }
}
