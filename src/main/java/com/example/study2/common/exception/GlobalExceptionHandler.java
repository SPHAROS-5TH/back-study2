package com.example.study2.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponseEntity> handleBusinessException(CustomException e){
        ErrorCode errorCode = e.getErrorCode();
        ErrorResponseEntity response = new ErrorResponseEntity(errorCode.getStatus(), errorCode.getCode(), errorCode.getDescription());

        return new ResponseEntity<>(response, HttpStatus.valueOf(errorCode.getStatus()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseEntity> handleException(Exception e){
        log.info("handleException : ", e);

        ErrorCode errorCode = ErrorCode.INTERNAL_SERVER_ERROR;
        ErrorResponseEntity response = new ErrorResponseEntity(errorCode.getStatus(), e.getMessage(), errorCode.getDescription());

        return new ResponseEntity<>(response, HttpStatus.valueOf(errorCode.getStatus()));
    }
}