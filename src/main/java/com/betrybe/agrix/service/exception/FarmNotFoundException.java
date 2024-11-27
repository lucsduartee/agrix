package com.betrybe.agrix.service.exception;

/**
 * Exception FarmNotFoundException.
 */
public class FarmNotFoundException extends NotFoundException {
  public FarmNotFoundException() {
    super("Fazenda não encontrada!");
  }
}
