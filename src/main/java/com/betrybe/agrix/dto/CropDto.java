package com.betrybe.agrix.dto;

import com.betrybe.agrix.entity.Crop;
import java.time.LocalDate;

/**
 * Crop Dto.
 *
 * @param id id.
 * @param name name.
 * @param plantedArea plantedArea.
 * @param farmId farmId.
 * @param plantedDate Planted Date.
 * @param harvestDate harvestDate.
 */
public record CropDto(
        Long id,
        String name,
        Double plantedArea,
        Long farmId,
        LocalDate plantedDate,
        LocalDate harvestDate
) {
  /**
   * Turn entity to dto.
   *
   * @param crop crop.
   * @return cropDto.
   */
  public static CropDto fromEntity(Crop crop) {
    return new CropDto(
            crop.getId(),
            crop.getName(),
            crop.getPlantedArea(),
            crop.getFarm().getId(),
            crop.getPlantedDate(),
            crop.getHarvestDate()
    );
  }
}
