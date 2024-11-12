package com.farmcollector.service;

import com.farmcollector.model.HarvestData;
import org.springframework.stereotype.Service;

@Service
public class HarvestService {

    /**
     * Simulates saving harvested data
     * @param harvestData Harvest information
     * @return Confirmation message
     */
    public String saveHarvestData(HarvestData harvestData) {
        // In a real app, you would save this data to a database
        return "Harvested data saved for " + harvestData.getFarmName() + " - " + harvestData.getCropType();
    }
}
