package com.farmcollector.repository;

import com.farmcollector.model.HarvestData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository interface for accessing and manipulating harvested data in the database.
 * Extends JpaRepository to provide CRUD operations for HarvestedData entities.
 */
public interface HarvestDataRepository extends JpaRepository<HarvestData, Long> {

    /**
     * Retrieves all harvested data for a specific farm.
     *
     * @param farmId The ID of the farm whose harvested data is to be retrieved.
     * @return A list of harvested data for the specified farm.
     */
    List<HarvestData> findByFarmId(Long farmId);

    /**
     * Finds harvested data by the ID and farm ID.
     *
     * @param id     The ID of the harvested data.
     * @param farmId The ID of the farm.
     * @return The harvested data matching the provided ID and farm ID.
     */
    HarvestData findByIdAndFarmId(Long id, Long farmId);
}
