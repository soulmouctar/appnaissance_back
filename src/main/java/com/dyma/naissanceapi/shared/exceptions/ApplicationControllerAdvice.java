package com.dyma.naissanceapi.shared.exceptions;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Slf4j
@ControllerAdvice
public class ApplicationControllerAdvice {
    @ResponseStatus(value = NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    public @ResponseBody ErrorEntity entityNotFoundExceptionHandler(EntityNotFoundException e) {
        //e.printStackTrace();
        log.error("Erreur, {}", e.getMessage(), e) ;
        return new ErrorEntity(
                LocalDateTime.now(),
                NOT_FOUND.value(),
                null,
                e.getMessage());
    }

    @ResponseStatus(value = BAD_REQUEST)
    @ExceptionHandler(RuntimeException.class)
    public @ResponseBody ErrorEntity runtimeExceptionHandler(RuntimeException  e) {
        log.error("Erreur, {}", e.getMessage(), e) ;
        return new ErrorEntity(
                LocalDateTime.now(),
                BAD_REQUEST.value(),
                null,
                e.getMessage());
    }

    @ResponseStatus(value = BAD_REQUEST)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public @ResponseBody ErrorEntity dataIntegrityViolationException(DataIntegrityViolationException   e) {
        log.error("Erreur, {}", e.getMessage(), e) ;
        return new ErrorEntity(
                LocalDateTime.now(),
                BAD_REQUEST.value(),
                null,
                "Phone number has been Duplicate");
    }

}
