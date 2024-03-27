package com.example.vacation_pay_calculator.service;

import com.example.vacation_pay_calculator.exceptions.DateException;
import com.example.vacation_pay_calculator.exceptions.SalaryException;
import com.example.vacation_pay_calculator.exceptions.VacationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class VacationPayServiceImpl implements VacationPayService {
    private final static int WORK_DAYS = 248;
    @Override
    public double calculate(double salary, int vacation) {
        salaryCheck(salary);
        if (vacation <= 0) {
            throw new VacationException("Vacation must be more then 0.");
        }
        log.info("Calculation by annual salary and number of vacation days");
        return (salary / WORK_DAYS) * vacation;
    }

    @Override
    public double calculateByDates(double salary, LocalDate vacationStart, LocalDate vacationEnd) {
        salaryCheck(salary);
        if (vacationStart.isAfter(vacationEnd)) {
            throw new DateException("Start date must be before end date.");
        }
        List<LocalDate> vacationDays = new ArrayList<>();
        for (LocalDate i = vacationStart; !i.equals(vacationEnd.plusDays(1)); i = i.plusDays(1)) {
            if (!VacationCalendar.isVacation(i)) vacationDays.add(i);
        }
        log.info("Calculating by annual salary and date interval.");
        return (salary / WORK_DAYS) * vacationDays.size();
    }

    private void salaryCheck(double salary) {
        if (salary < 0) {
            throw new SalaryException("Salary must be more then 0.");
        }
    }
}
