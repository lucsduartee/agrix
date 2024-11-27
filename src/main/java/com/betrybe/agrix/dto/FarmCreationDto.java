package com.betrybe.agrix.dto;

import com.betrybe.agrix.entity.Farm;

/**
 * Farm Creation Dto.
 *
 * @param name Farm name.
 * @param size Farm size.
 */
public record FarmCreationDto(
        String name,
        Double size
) {
  public Farm toEntity() {
    return new Farm(name, size);
  }
}
