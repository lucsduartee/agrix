package com.betrybe.agrix.service.exception;

/**
 * FertilizerNotFoundException.
 */
public class FertilizerNotFoundException extends NotFoundException {
  public FertilizerNotFoundException() {
    super("Fertilizante não encontrado!");
  }
}
