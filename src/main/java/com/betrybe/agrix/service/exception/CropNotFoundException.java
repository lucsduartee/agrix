package com.betrybe.agrix.service.exception;

/**
 * Exception CropNotFoundException.
 */
public class CropNotFoundException extends NotFoundException {
  public CropNotFoundException() {
    super("Plantação não encontrada!");
  }
}
