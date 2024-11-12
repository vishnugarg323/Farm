package com.farmcollector.controller;

import com.farmcollector.model.HarvestData;
import com.farmcollector.service.HarvestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for handling Harvested Data APIs.
 * Provides endpoints for managing harvested data for a specific farm.
 */
@RestController
@RequestMapping("/api/farm/{farmId}/harvested")
public class HarvestController {

    @Autowired
    private HarvestService harvestService;

    /**
     * Creates new harvested data for a specific farm.
     * Responds with HTTP status 201 (Created) on success.
     *
     * @param farmId         The ID of the farm where the harvested data will be added.
     * @param harvestData  The harvested data to be created.
     * @return The response with the created harvested data and HTTP status 201 (Created).
     */
    @PostMapping
    public ResponseEntity<HarvestData> createHarvestedData(@PathVariable Long farmId, @RequestBody HarvestData harvestData) {
        if (harvestData == null || harvestData.getCropType() == null || harvestData.getActualAmount() <= 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // 400 Bad Request if data is invalid
        }

        HarvestData createdHarvestedData = harvestService.createHarvestedData(farmId, harvestData);
        return new ResponseEntity<>(createdHarvestedData, HttpStatus.CREATED); // 201 Created on success
    }

    /**
     * Retrieves all harvested data for a specific farm.
     *
     * @param farmId The ID of the farm whose harvested data is to be retrieved.
     * @return A list of harvested data and HTTP status 200 (OK).
     */
    @GetMapping
    public ResponseEntity<Iterable<HarvestData>> getHarvestedData(@PathVariable Long farmId) {
        Iterable<HarvestData> harvestedData = harvestService.getHarvestedData(farmId);
        return new ResponseEntity<>(harvestedData, HttpStatus.OK); // 200 OK
    }
}
