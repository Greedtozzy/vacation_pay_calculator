package com.example.vacation_pay_calculator.service;

import com.example.vacation_pay_calculator.exceptions.DateException;
import com.example.vacation_pay_calculator.exceptions.SalaryException;
import com.example.vacation_pay_calculator.exceptions.VacationException;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class VacationPayServiceTest {
    VacationPayServiceImpl vacationPayService = new VacationPayServiceImpl();

    @Test
    public void calculateBy248kSalaryAnd10DaysTest() {
        assertEquals(vacationPayService.calculate(248000, 10), 10000);
    }

    @Test
    public void calculateByWrongSalaryTest() {
        SalaryException thrown= assertThrows(SalaryException.class,
                () -> vacationPayService.calculate(-10, 10));
        assertEquals("Salary must be more then 0.", thrown.getMessage());
    }

    @Test
    public void calculateByWrongVacationTest() {
        VacationException thrown = assertThrows(VacationException.class,
                () -> vacationPayService.calculate(10, -10));
        assertEquals("Vacation must be more then 0.", thrown.getMessage());
    }

    @Test
    public void calculateBy248kSalaryAndDatesTest() {
        assertEquals(vacationPayService.calculateByDates(248000, LocalDate.of(2024,1,1), LocalDate.of(2024, 1,10)), 2000);
    }

    @Test
    public void calculateByWrongDatesTest() {
        DateException thrown = assertThrows(DateException.class,
                () -> vacationPayService.calculateByDates(10, LocalDate.of(2024,2,1), LocalDate.of(2024,1,1)));
        assertEquals("Start date must be before end date.", thrown.getMessage());
    }
}
