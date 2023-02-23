package com.example.pragraplex.rest;

import com.example.pragraplex.dto.ErrorDto;
import com.example.pragraplex.exceptions.CustomerNotFoundException;
import com.example.pragraplex.exceptions.MovieNotFoundException;
import com.example.pragraplex.exceptions.OrderNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ErrorControllerAdvice {
    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ErrorDto> handleCustomerNotFound(CustomerNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorDto.builder().
                errorCode(1005).message(ex.getMessage()).errorDate(new Date()).build());
    }
    @ExceptionHandler(MovieNotFoundException.class)
    public ResponseEntity<ErrorDto> handleMovieNotFound(MovieNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorDto.builder()
                .errorCode(1001).message(ex.getMessage()).errorDate(new Date()).build());
    }
    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<ErrorDto> handleOrderNotFound(OrderNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorDto.builder()
                .errorCode(1007).message(ex.getMessage()).errorDate(new Date()).build());
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorDto> handleNullPointerException(Exception ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorDto.builder()
                .errorCode(3000).message(ex.getMessage()).errorDate(new Date()).build());
    }
}
