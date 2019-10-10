package com.stackroute.MovieApp.exception;

import com.stackroute.MovieApp.exception.MovieNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AdviceController extends ResponseEntityExceptionHandler {

  @ExceptionHandler(value = Exception.class)
  public ResponseEntity<String> exceptionHandler(Exception e) {
    return new ResponseEntity<>("Error thrown globally : " + e.getMessage(), HttpStatus.CONFLICT);
  }

}
