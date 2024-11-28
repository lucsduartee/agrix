package com.betrybe.agrix.controller;

import com.betrybe.agrix.dto.CropDto;
import com.betrybe.agrix.dto.FertilizerDto;
import com.betrybe.agrix.service.CropService;
import com.betrybe.agrix.service.exception.CropNotFoundException;
import com.betrybe.agrix.service.exception.FertilizerNotFoundException;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Crop Controller.
 */
@RestController
@RequestMapping("/crops")
public class CropController {
  @Autowired
  private CropService cropService;

  /**
   * Get a crop by id.
   *
   * @param id Crop id.
   * @return Crop.
   */
  @GetMapping("/{id}")
  public CropDto getById(
          @PathVariable Long id
  ) {
    return CropDto.fromEntity(
            cropService.findById(id)
    );
  }

  /**
   * Get all crops.
   *
   * @return Crops list.
   */
  @GetMapping
  @PreAuthorize("hasAuthority('ROLE_ADMIN') "
          + "or hasAuthority('ROLE_MANAGER')")
  public List<CropDto> getAllCrops() {
    return cropService.findAll()
            .stream()
            .map(CropDto::fromEntity)
            .toList();
  }

  /**
   * Search crops by harvest date.
   *
   * @param start Start.
   * @param end end.
   * @return Crops list.
   */
  @GetMapping("/search")
  public List<CropDto> search(
          @RequestParam("start") LocalDate start,
          @RequestParam("end") LocalDate end
  ) {
    return cropService.searchBetweenDates(start, end)
            .stream()
            .map(CropDto::fromEntity)
            .toList();
  }

  /**
   * Creates Fertilizer By Crop.
   *
   * @param cropId cropId.
   * @param fertilizerId fertilizerId.
   * @return message String.
   * @throws CropNotFoundException exception
   * @throws FertilizerNotFoundException exception
   */
  @PostMapping("/{cropId}/fertilizers/{fertilizerId}")
  @ResponseStatus(HttpStatus.CREATED)
  public String createFertilizerByCrop(
          @PathVariable Long cropId,
          @PathVariable Long fertilizerId
  ) throws CropNotFoundException, FertilizerNotFoundException {
    return cropService.createFertilizerByCrop(cropId, fertilizerId);
  }

  /**
   * Get Fertilizers By Crop.
   *
   * @param cropId cropId.
   * @return Crop List.
   * @throws CropNotFoundException exception.
   */
  @GetMapping("/{cropId}/fertilizers")
  public List<FertilizerDto> getFertilizersByCrop(
         @PathVariable Long cropId
  ) throws CropNotFoundException {
    return cropService.getFertilizersByCrop(cropId)
            .stream()
            .map(FertilizerDto::fromEntity)
            .toList();
  }
}
