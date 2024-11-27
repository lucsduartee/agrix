package com.betrybe.agrix.dto;

import com.betrybe.agrix.entity.Farm;

/**
 * Farm Dto.
 *
 * @param id Unique identifier.
 * @param name Farm name.
 * @param size Farm size
 */
public record FarmDto(
        Long id,
        String name,
        Double size
) {
  /**
   * Creates a Dto for responses.
   *
   * @param farm Farm created.
   * @return FarmDto
   */
  public static FarmDto fromEntity(Farm farm) {
    return new FarmDto(
            farm.getId(),
            farm.getName(),
            farm.getSize()
    );
  }
}
