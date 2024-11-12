package com.farmcollector.controller;

import com.farmcollector.model.HarvestData;
import com.farmcollector.service.HarvestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/harvest")
public class HarvestController {

    @Autowired
    private HarvestService harvestService;

    /**
     * API to add harvested data
     * @param harvestData Data for the harvested crops
     * @return Confirmation message
     */
    @PostMapping("/add")
    public String addHarvestData(@RequestBody HarvestData harvestData) {
        return harvestService.saveHarvestData(harvestData);
    }
}
