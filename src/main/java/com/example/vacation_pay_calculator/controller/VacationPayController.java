package com.example.vacation_pay_calculator.controller;

import com.example.vacation_pay_calculator.service.VacationPayService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(path = "/calculate")
@RequiredArgsConstructor
public class VacationPayController {
    private final VacationPayService service;

    @GetMapping
    public double calculate(@RequestParam(value = "salary") double salary,
                            @RequestParam(value = "vacation") int vacation) {
        return service.calculate(salary, vacation);
    }

    @GetMapping(path = "/dates")
    public double calculateByDates(@RequestParam(value = "salary") double salary,
                                   @RequestParam(value = "vacationStart") @DateTimeFormat(pattern = "yyyy-mm-dd") LocalDate vacationStart,
                                   @RequestParam(value = "vacationEnd") @DateTimeFormat(pattern = "yyyy-mm-dd") LocalDate vacationEnd) {
        return service.calculateByDates(salary, vacationStart, vacationEnd);
    }
}
