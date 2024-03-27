package com.example.vacation_pay_calculator.service;

import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class VacationCalendar {
    private final static List<LocalDate> calendar = fillOutCalendar();

    public static boolean isVacation(LocalDate date) {
        return calendar.contains(date);
    }

    private static List<LocalDate> fillOutCalendar() {
        List<LocalDate> fillableCalendar = new ArrayList<>();
        int count = 1;
        for (LocalDate i = LocalDate.of(2024, 1, 1);
             !i.equals(LocalDate.of(2025, 1, 1));
             i = i.plusDays(1)) {
            if (count >= 6) {
                fillableCalendar.add(i);
            }
            if (count == 7) {
                count = 0;
            }
            count++;
        }

        fillableCalendar.add(LocalDate.of(2024, 1, 1));
        fillableCalendar.add(LocalDate.of(2024, 1, 2));
        fillableCalendar.add(LocalDate.of(2024, 1, 3));
        fillableCalendar.add(LocalDate.of(2024, 1, 4));
        fillableCalendar.add(LocalDate.of(2024, 1, 5));
        fillableCalendar.add(LocalDate.of(2024, 1, 8));
        fillableCalendar.add(LocalDate.of(2024, 2, 23));
        fillableCalendar.add(LocalDate.of(2024, 3, 8));
        fillableCalendar.add(LocalDate.of(2024, 4, 29));
        fillableCalendar.add(LocalDate.of(2024, 4, 30));
        fillableCalendar.add(LocalDate.of(2024, 5, 1));
        fillableCalendar.add(LocalDate.of(2024, 5, 9));
        fillableCalendar.add(LocalDate.of(2024, 5, 10));
        fillableCalendar.add(LocalDate.of(2024, 5, 11));
        fillableCalendar.add(LocalDate.of(2024, 5, 12));
        fillableCalendar.add(LocalDate.of(2024, 6, 12));
        fillableCalendar.add(LocalDate.of(2024, 11, 3));
        fillableCalendar.add(LocalDate.of(2024, 11, 4));
        fillableCalendar.add(LocalDate.of(2024, 12, 29));
        fillableCalendar.add(LocalDate.of(2024, 12, 30));
        fillableCalendar.add(LocalDate.of(2024, 12, 31));

        return fillableCalendar;
    }
}
