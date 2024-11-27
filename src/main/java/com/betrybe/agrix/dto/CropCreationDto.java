package com.betrybe.agrix.dto;

import com.betrybe.agrix.entity.Crop;
import java.time.LocalDate;

/**
 * CropCreationDto.
 *
 * @param name name.
 * @param plantedArea plantedArea.
 * @param plantedDate plantedDate
 * @param harvestDate harvestDate.
 */
public record CropCreationDto(
        String name,
        Double plantedArea,
        LocalDate plantedDate,
        LocalDate harvestDate
) {
  public Crop toEntity() {
    return new Crop(name, plantedArea, plantedDate, harvestDate);
  }
}
