package com.example.restaurant_mobile.logic;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeController {

    private final LocalTime startTime;
    private final LocalTime endTime;
    private final DateTimeFormatter formatter;

    public TimeController(String start, String end) {
        formatter = DateTimeFormatter.ofPattern("HH:mm");
        startTime = LocalTime.parse(start, formatter);
        endTime = LocalTime.parse(end, formatter);
    }

    public String changeTime(String current, int minutes) {
        LocalTime currentTime = LocalTime.parse(current, formatter);
        LocalTime newTime = currentTime.plusMinutes(minutes);

        if (!newTime.isBefore(startTime) && !newTime.isAfter(endTime)) {
            return newTime.format(formatter);
        }
        return null;
    }
}
