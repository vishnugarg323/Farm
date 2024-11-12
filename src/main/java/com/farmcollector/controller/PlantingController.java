package com.farmcollector.controller;

import com.farmcollector.model.PlantingData;
import com.farmcollector.service.PlantingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for handling Planting Data APIs.
 * Provides endpoints for managing planting data for a specific farm.
 */
@RestController
@RequestMapping("/api/farm/{farmId}/planting")
public class PlantingController {

    @Autowired
    private PlantingService plantingService;

    /**
     * Creates new planting data for a specific farm.
     * Responds with HTTP status 201 (Created) on success.
     *
     * @param farmId       The ID of the farm where the planting data will be added.
     * @param plantingData The planting data to be created.
     * @return The response with the created planting data and HTTP status 201 (Created).
     */
    @PostMapping
    public ResponseEntity<PlantingData> createPlantingData(@PathVariable Long farmId, @RequestBody PlantingData plantingData) {
        if (plantingData == null || plantingData.getCropType() == null || plantingData.getAreaPlanted() <= 0 || plantingData.getExpectedAmount() <= 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // 400 Bad Request if data is invalid
        }

        PlantingData createdPlantingData = plantingService.createPlantingData(farmId, plantingData);
        return new ResponseEntity<>(createdPlantingData, HttpStatus.CREATED); // 201 Created on success
    }

    /**
     * Retrieves all planting data for a specific farm.
     *
     * @param farmId The ID of the farm whose planting data is to be retrieved.
     * @return A list of planting data and HTTP status 200 (OK).
     */
    @GetMapping
    public ResponseEntity<Iterable<PlantingData>> getPlantingData(@PathVariable Long farmId) {
        Iterable<PlantingData> plantingData = plantingService.getPlantingData(farmId);
        return new ResponseEntity<>(plantingData, HttpStatus.OK); // 200 OK
    }
}
