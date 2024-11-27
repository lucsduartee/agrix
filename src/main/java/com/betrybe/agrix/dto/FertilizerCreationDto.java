package com.betrybe.agrix.dto;

import com.betrybe.agrix.entity.Fertilizer;

/**
 * FertilizerCreationDto.
 *
 * @param brand brand.
 * @param name name.
 * @param composition composition.
 */
public record FertilizerCreationDto(
    String brand,
    String name,
    String composition
) {
  /**
   * To entity.
   *
   * @return Fertilizer.
   */
  public Fertilizer toEntity() {
    return new Fertilizer(
            name,
            brand,
            composition
    );
  }
}
