package com.sadatspringbootcourse.socialmedia.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> generalExceptionHandler(Exception ex, WebRequest request) throws Exception {
        ErrorDetails errorDetails=new ErrorDetails(LocalDate.now(),ex.getMessage(),request.getDescription(false));
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDetails);
    }


    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<ErrorDetails> userNotFoundExceptionHandler(Exception ex, WebRequest request) throws Exception {
        ErrorDetails errorDetails=new ErrorDetails(LocalDate.now(),"User not found "+ex.getMessage(),request.getDescription(false));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDetails);
    }

    @ExceptionHandler(PostNotFoundException.class)
    public final ResponseEntity<ErrorDetails> postnotfoundExceptionHandler(Exception ex, WebRequest request) throws Exception {
        ErrorDetails errorDetails=new ErrorDetails(LocalDate.now(),ex.getMessage(),request.getDescription(false));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDetails);
    }



}
