package com.farmcollector.service;

import com.farmcollector.model.CropData;
import org.springframework.stereotype.Service;

@Service
public class PlantingService {
    /**
     * Simulates saving planting data
     * @param cropData Planting information
     * @return Confirmation message
     */
    public String savePlantingData(CropData cropData) {
        // Save planting data logic (could be in database or in-memory)
        return "Planting data saved successfully for " + cropData.getFarmName() + " - " + cropData.getCropType();
    }
}
