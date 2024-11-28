package com.betrybe.agrix.controller;

import com.betrybe.agrix.dto.FertilizerCreationDto;
import com.betrybe.agrix.dto.FertilizerDto;
import com.betrybe.agrix.service.FertilizerService;
import com.betrybe.agrix.service.exception.FertilizerNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Fertilizer controller.
 */
@RestController
@RequestMapping("/fertilizers")
public class FertilizerController {
  @Autowired
  private FertilizerService fertilizerService;

  /**
   * Creates fertilizer.
   *
   * @param fertilizerCreationDto fertilizerCreationDto.
   * @return fertilizer dto.
   */
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public FertilizerDto createFertilizer(@RequestBody FertilizerCreationDto fertilizerCreationDto) {
    return FertilizerDto.fromEntity(
            fertilizerService.create(fertilizerCreationDto.toEntity())
    );
  }

  /**
   * Get all fertilizer.
   *
   * @return FertilizerDto List.
   */
  @GetMapping
  @PreAuthorize("hasAuthority('ROLE_ADMIN')")
  public List<FertilizerDto> getAll() {
    return fertilizerService.findAll()
            .stream()
            .map(FertilizerDto::fromEntity)
            .toList();
  }

  /**
   * Retrieves fertilizer.
   *
   * @param fertilizerId Id.
   * @return Fertilizer Dto.
   */
  @GetMapping("/{fertilizerId}")
  public FertilizerDto getById(
          @PathVariable Long fertilizerId
  ) throws FertilizerNotFoundException {
    return FertilizerDto.fromEntity(
            fertilizerService.findById(fertilizerId)
    );
  }
}
