package com.example.vacation_pay_calculator.service;

import java.time.LocalDate;

public interface VacationPayService {
    double calculate(double salary, int vacation);
    double calculateByDates(double salary, LocalDate vacationStart, LocalDate vacationEnd);
}
