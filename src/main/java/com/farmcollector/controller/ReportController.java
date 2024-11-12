package com.farmcollector.controller;

import com.farmcollector.model.CropData;
import com.farmcollector.service.PlantingService;
import com.farmcollector.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    /**
     * API to get report data
     * @return Confirmation message
     */
    @PostMapping("/add")
    public String addPlantingData() {
        return reportService.getReport();
    }
}
