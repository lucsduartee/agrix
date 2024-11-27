package com.betrybe.agrix.dto;

import com.betrybe.agrix.entity.Fertilizer;

/**
 * Fertilizer Dto.
 *
 * @param id id.
 * @param name name.
 * @param brand brand.
 * @param composition composition.
 */
public record FertilizerDto(
        Long id,
        String name,
        String brand,
        String composition
) {
  /**
   * Dto from entity.
   *
   * @param fertilizer Fertilizer.
   * @return FertilizerDto.
   */
  public static FertilizerDto fromEntity(Fertilizer fertilizer) {
    return new FertilizerDto(
            fertilizer.getId(),
            fertilizer.getName(),
            fertilizer.getBrand(),
            fertilizer.getComposition()
    );
  }
}
