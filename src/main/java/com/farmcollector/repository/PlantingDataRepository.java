package com.farmcollector.repository;

import com.farmcollector.model.PlantingData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository interface for accessing and manipulating planting data in the database.
 * Extends JpaRepository to provide CRUD operations for PlantingData entities.
 */
public interface PlantingDataRepository extends JpaRepository<PlantingData, Long> {

    /**
     * Retrieves all planting data for a specific farm.
     *
     * @param farmId The ID of the farm whose planting data is to be retrieved.
     * @return A list of planting data for the specified farm.
     */
    List<PlantingData> findByFarmId(Long farmId);

    /**
     * Finds planting data by the ID and farm ID.
     *
     * @param id     The ID of the planting data.
     * @param farmId The ID of the farm.
     * @return The planting data matching the provided ID and farm ID.
     */
    PlantingData findByIdAndFarmId(Long id, Long farmId);
}
