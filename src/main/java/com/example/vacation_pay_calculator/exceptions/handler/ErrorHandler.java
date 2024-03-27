package com.example.vacation_pay_calculator.exceptions.handler;

import com.example.vacation_pay_calculator.exceptions.DateException;
import com.example.vacation_pay_calculator.exceptions.SalaryException;
import com.example.vacation_pay_calculator.exceptions.VacationException;
import com.example.vacation_pay_calculator.exceptions.dto.ApiError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
@Slf4j
public class ErrorHandler {
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleDateException(final DateException e) {
        log.warn(e.getMessage());
        return new ApiError(HttpStatus.BAD_REQUEST, "Wrong date", e.getMessage(), LocalDateTime.now());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleSalaryException(final SalaryException e) {
        log.warn(e.getMessage());
        return new ApiError(HttpStatus.BAD_REQUEST, "Wrong salary", e.getMessage(), LocalDateTime.now());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleVacationException(final VacationException e) {
        log.warn(e.getMessage());
        return new ApiError(HttpStatus.BAD_REQUEST, "Wrong vacation amount", e.getMessage(), LocalDateTime.now());
    }
}