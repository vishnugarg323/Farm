package com.farmcollector.service;

import com.farmcollector.model.HarvestData;
import com.farmcollector.model.PlantingData;
import com.farmcollector.repository.HarvestDataRepository;
import com.farmcollector.repository.PlantingDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for generating reports for farm data.
 * This service compares the expected and actual harvest for each farm, based on the planting and harvesting data.
 */
@Service
public class ReportService {

    @Autowired
    private PlantingDataRepository plantingDataRepository;

    @Autowired
    private HarvestDataRepository harvestedDataRepository;

    /**
     * Generates a textual report comparing the planted vs harvested data for a specific farm.
     * The report compares expected and actual yields for each crop in the farm.
     *
     * @param farmId The ID of the farm for which to generate the report.
     * @return A formatted report containing expected vs actual values for each crop.
     */
    // Generate a report comparing planted vs harvested data for a specific farm
    public String generateFarmReport(Long farmId) {
        List<PlantingData> plantedData = plantingDataRepository.findByFarmId(farmId);
        List<HarvestData> harvestedData = harvestedDataRepository.findByFarmId(farmId);

        StringBuilder report = new StringBuilder();
        for (PlantingData planting : plantedData) {
            String cropType = planting.getCropType();
            double expected = planting.getExpectedAmount();
            double actual = harvestedData.stream()
                    .filter(h -> h.getCropType().equals(cropType))
                    .mapToDouble(HarvestData::getActualAmount)
                    .findFirst()
                    .orElse(0.0);
            report.append(String.format("Crop: %s\nPlanted: %.2f tons\nHarvested: %.2f tons\n\n", cropType, expected, actual));
        }
        return report.toString();
    }

    /**
     * Simulates get report data
     * @return Confirmation message
     */
    public String getReport() {
        // Save planting data logic (could be in database or in-memory)
        return "You have successfully obtained the report";
    }
}
