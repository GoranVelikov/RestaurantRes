package com.example.restaurant_mobile.model;

public class ReservationRequest {

    public int tableId;
    public String customerName;
    public String dateTime;
    public int guests;

    public ReservationRequest(int tableId, String customerName, String dateTime, int guests) {
        this.tableId = tableId;
        this.customerName = customerName;
        this.dateTime = dateTime;
        this.guests = guests;
    }
}
