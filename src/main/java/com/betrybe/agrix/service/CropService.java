package com.betrybe.agrix.service;

import com.betrybe.agrix.entity.Crop;
import com.betrybe.agrix.entity.Farm;
import com.betrybe.agrix.entity.Fertilizer;
import com.betrybe.agrix.repository.CropRepository;
import com.betrybe.agrix.service.exception.CropNotFoundException;
import com.betrybe.agrix.service.exception.FertilizerNotFoundException;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Crop Service.
 */
@Service
public class CropService {
  @Autowired
  private CropRepository cropRepository;

  @Autowired
  private FarmService farmService;

  @Autowired
  private FertilizerService fertilizerService;

  public Crop findById(Long id) throws CropNotFoundException {
    return cropRepository.findById(id).orElseThrow(CropNotFoundException::new);
  }

  public List<Crop> findAll() {
    return cropRepository.findAll();
  }

  /**
   * Creates a crop.
   *
   * @param farmId farm id.
   * @param crop crop.
   * @return Crop.
   */
  public Crop createCrop(Long farmId, Crop crop) {
    Farm farm = farmService.findById(farmId);
    crop.setFarm(farm);
    return cropRepository.save(crop);
  }

  /**
   * Search crops between dates.
   *
   * @param start Start.
   * @param end End.
   * @return Crops List
   */
  public List<Crop> searchBetweenDates(LocalDate start, LocalDate end) {
    return findAll()
            .stream()
            .filter(crop -> {
              LocalDate harvestDate = crop.getHarvestDate();

              return (harvestDate.isEqual(start) || harvestDate.isAfter(start))
                     && (harvestDate.isEqual(end) || harvestDate.isBefore(end));
            })
            .toList();
  }

  /**
   * Associates crop and fertilizer.
   *
   * @param cropId cropId.
   * @param fertilizerId fertilizerId.
   * @return String message.
   * @throws CropNotFoundException exception.
   * @throws FertilizerNotFoundException exception.
   */
  public String createFertilizerByCrop(
          Long cropId,
          Long fertilizerId
  ) throws CropNotFoundException, FertilizerNotFoundException {
    Crop crop = findById(cropId);
    Fertilizer fertilizer = fertilizerService.findById(fertilizerId);

    crop.getFertilizers().add(fertilizer);
    cropRepository.save(crop);

    return "Fertilizante e plantação associados com sucesso!";
  }

  /**
   * Retrieves fertilizers by crop id.
   *
   * @param cropId cropId.
   * @return Fertilizer List.
   * @throws CropNotFoundException exception.
   */
  public List<Fertilizer> getFertilizersByCrop(
          Long cropId
  ) throws CropNotFoundException {
    return findById(cropId)
            .getFertilizers();
  }
}
