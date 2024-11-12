package com.farmcollector.service;

import com.farmcollector.model.HarvestData;
import com.farmcollector.repository.HarvestDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service for managing harvested data.
 * Provides methods to create, update, and retrieve harvested data for a specific farm.
 */
@Service
public class HarvestService {

    @Autowired
    private HarvestDataRepository harvestedDataRepository;

    /**
     * Retrieve all harvested data for a specific farm.
     *
     * @param farmId The ID of the farm for which to retrieve harvested data.
     * @return A list of harvested data for the specified farm.
     */
    public List<HarvestData> getHarvestedData(Long farmId) {
        return harvestedDataRepository.findByFarmId(farmId);
    }

    /**
     * Create new harvested data for a farm.
     *
     * @param farmId        The ID of the farm.
     * @param harvestedData The harvested data to be created.
     * @return The newly created harvested data.
     */
    public HarvestData createHarvestedData(Long farmId, HarvestData harvestedData) {
        harvestedData.setFarmId(farmId);
        return harvestedDataRepository.save(harvestedData);
    }

    /**
     * Update existing harvested data for a specific farm.
     *
     * @param farmId        The ID of the farm.
     * @param id            The ID of the harvested data to update.
     * @param harvestedData The new harvested data to be updated.
     * @return The updated harvested data.
     */
    public HarvestData updateHarvestedData(Long farmId, Long id, HarvestData harvestedData) {
        Optional<HarvestData> existingData = harvestedDataRepository.findById(id);
        if (existingData.isPresent()) {
            HarvestData existing = existingData.get();
            existing.setCropType(harvestedData.getCropType());
            existing.setActualAmount(harvestedData.getActualAmount());
            return harvestedDataRepository.save(existing);
        }
        return null;
    }

    /**
     * Simulates saving harvested data
     * @param harvestData Harvest information
     * @return Confirmation message
     */
    public String saveHarvestData(HarvestData harvestData) {
        // In a real app, you would save this data to a database
        return "Harvested data saved successfully";
    }
}
