package com.farmcollector.service;

import com.farmcollector.model.PlantingData;
import com.farmcollector.repository.PlantingDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service for managing planting data.
 * Provides methods to create, update, and retrieve planting data for a specific farm.
 */
@Service
public class PlantingService {

    @Autowired
    private PlantingDataRepository plantingDataRepository;

    /**
     * Retrieve all planting data for a specific farm.
     *
     * @param farmId The ID of the farm for which to retrieve planting data.
     * @return A list of planting data for the specified farm.
     */
    public List<PlantingData> getPlantingData(Long farmId) {
        return plantingDataRepository.findByFarmId(farmId);
    }

    /**
     * Create new planting data for a farm.
     *
     * @param farmId       ID of the farm.
     * @param plantingData Planting data to be saved.
     * @return Saved planting data.
     */
    public PlantingData createPlantingData(Long farmId, PlantingData plantingData) {
        plantingData.setFarmId(farmId);
        return plantingDataRepository.save(plantingData);
    }

    /**
     * Update existing planting data for a specific farm.
     *
     * @param farmId       The ID of the farm.
     * @param id           The ID of the planting data to update.
     * @param plantingData The new planting data to be updated.
     * @return The updated planting data.
     */
    public PlantingData updatePlantingData(Long farmId, Long id, PlantingData plantingData) {
        Optional<PlantingData> existingData = plantingDataRepository.findById(id);
        if (existingData.isPresent()) {
            PlantingData existing = existingData.get();
            existing.setCropType(plantingData.getCropType());
            existing.setAreaPlanted(plantingData.getAreaPlanted());
            existing.setExpectedAmount(plantingData.getExpectedAmount());
            return plantingDataRepository.save(existing);
        }
        return null;
    }

    /**
     * Simulates saving planting data
     * @param cropData Planting information
     * @return Confirmation message
     */
    public String savePlantingData(PlantingData cropData) {
        // Save planting data logic (could be in database or in-memory)
        return "Planting data saved successfully";
    }
}
