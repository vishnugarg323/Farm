package com.farmcollector.controller;

import com.farmcollector.model.CropData;
import com.farmcollector.service.PlantingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/planting")
public class PlantingController {

    @Autowired
    private PlantingService plantingService;

    /**
     * API to add planting data
     * @param cropData Data for the planted crops
     * @return Confirmation message
     */
    @PostMapping("/add")
    public String addPlantingData(@RequestBody CropData cropData) {
        return plantingService.savePlantingData(cropData);
    }
}
