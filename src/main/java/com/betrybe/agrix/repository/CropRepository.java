package com.betrybe.agrix.repository;

import com.betrybe.agrix.entity.Crop;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * CropRepository.
 */
public interface CropRepository extends JpaRepository<Crop, Long> { }
