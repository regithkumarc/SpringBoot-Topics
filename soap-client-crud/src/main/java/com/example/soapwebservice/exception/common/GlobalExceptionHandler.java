package com.example.soapwebservice.exception.common;

import com.example.soapwebservice.exception.ArticlesNotFoundException;
import com.example.soapwebservice.exception.EmployeesNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = EmployeesNotFoundException.class)
    public ErrorResponse employeeNotFound(EmployeesNotFoundException exception) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
        errorResponse.setMessage(exception.getMessage());

        return errorResponse;
    }

    @ExceptionHandler(value = ArticlesNotFoundException.class)
    public ErrorResponse articlesNotFound(ArticlesNotFoundException exception) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
        errorResponse.setMessage(exception.getMessage());

        return errorResponse;
    }
}
