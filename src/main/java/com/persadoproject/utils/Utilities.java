package com.persadoproject.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Utilities {
    public static String formatFullDateDescription(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMMM/YYYY");
        String[] dateList = formatter.format(date).split("/");
        int day = Integer.parseInt(dateList[0]);
        String suffix = Utilities.getDayNumberSuffix(day);
        return day + suffix + " of " +  dateList[1] + " " + dateList[2];
    }

    public static String getDayNumberSuffix(int day) {
        if (day >= 11 && day <= 13) {
            return "th";
        }
        switch (day % 10) {
            case 1:
                return "st";
            case 2:
                return "nd";
            case 3:
                return "rd";
            default:
                return "th";
        }
    }
}
