package com.betrybe.agrix.service.exception;

/**
 * Exception NotFoundException.
 */
public class NotFoundException extends RuntimeException {
  public NotFoundException(String message) {
    super(message);
  }
}
