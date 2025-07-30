package com.fuelpool.backend.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    private static final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.systemDefault());

    public static String formatInstant(Instant instant) {
        return formatter.format(instant);
    }

    public static Instant parseToInstant(String dateTimeString) {
        LocalDateTime localDateTime = LocalDateTime.parse(dateTimeString, formatter);
        return localDateTime.atZone(ZoneId.systemDefault()).toInstant();
    }
}
