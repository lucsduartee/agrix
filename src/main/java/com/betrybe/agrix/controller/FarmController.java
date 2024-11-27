package com.betrybe.agrix.controller;

import com.betrybe.agrix.dto.CropCreationDto;
import com.betrybe.agrix.dto.CropDto;
import com.betrybe.agrix.dto.FarmCreationDto;
import com.betrybe.agrix.dto.FarmDto;
import com.betrybe.agrix.entity.Crop;
import com.betrybe.agrix.entity.Farm;
import com.betrybe.agrix.service.CropService;
import com.betrybe.agrix.service.FarmService;
import com.betrybe.agrix.service.exception.FarmNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;



/**
 * Controller FarmController.
 */
@RestController
@RequestMapping(value = "/farms")
public class FarmController {
  @Autowired
  private FarmService farmService;

  @Autowired
  private CropService cropService;

  /**
   * List all farms.
   *
   * @return List of FarmDtos.
   */
  @GetMapping
  public List<FarmDto> getAllFarms() {
    List<Farm> farms = farmService.findAll();
    return farms.stream()
            .map(FarmDto::fromEntity)
            .toList();
  }

  /**
   * Get a farm by id.
   *
   * @param id Identifier.
   * @return Farm Dto.
   * @throws FarmNotFoundException Exception.
   */
  @GetMapping("/{id}")
  public FarmDto getFarmById(
      @PathVariable Long id
  ) throws FarmNotFoundException {
    return FarmDto.fromEntity(
            farmService.findById(id)
    );
  }

  /**
   * Creation route.
   *
   * @param farmCreationDto Creation Payload.
   * @return FarmDto.
   */
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public FarmDto createFarm(@RequestBody FarmCreationDto farmCreationDto) {
    return FarmDto.fromEntity(
            farmService.create(farmCreationDto.toEntity())
    );
  }

  /**
   * Get all crops from specific farm.
   *
   * @param farmId farmId.
   * @return CropDto List.
   */
  @GetMapping("/{farmId}/crops")
  public List<CropDto> getCropsByFarmId(
          @PathVariable Long farmId
  ) {
    List<Crop> crops = farmService.findAllCropsByFarm(farmId);

    return crops.stream()
            .map(CropDto::fromEntity)
            .toList();
  }

  /**
   * Create a crop.
   *
   * @param farmId farm id.
   * @param cropCreationDto cropCreationDto.
   * @return CropDto.
   */
  @PostMapping("/{farmId}/crops")
  @ResponseStatus(HttpStatus.CREATED)
  public CropDto createCrop(
          @PathVariable Long farmId,
          @RequestBody CropCreationDto cropCreationDto
  ) {
    return CropDto.fromEntity(
      cropService.createCrop(farmId, cropCreationDto.toEntity())
    );
  }
}
