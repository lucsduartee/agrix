package com.betrybe.agrix;

import com.betrybe.agrix.service.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Global Controller Advice.
 */
@ControllerAdvice
public class GlobalAdvice {
  @ExceptionHandler
  public ResponseEntity<String> handleNotFoundException(
          NotFoundException exception
  ) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(exception.getMessage());
  }
}
