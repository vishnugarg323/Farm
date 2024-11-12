package com.farmcollector.controller;

import com.farmcollector.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for generating farm reports.
 * Provides an endpoint to generate a report comparing planted vs harvested data for a specific farm.
 */
@RestController
@RequestMapping("/api/farm/{farmId}/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    /**
     * Generates a report for a specific farm, comparing expected and actual yield for each crop.
     * Responds with HTTP status 200 (OK) on success.
     *
     * @param farmId The ID of the farm for which the report is to be generated.
     * @return A formatted report and HTTP status 200 (OK).
     */
    @GetMapping
    public ResponseEntity<String> generateFarmReport(@PathVariable Long farmId) {
        String report = reportService.generateFarmReport(farmId);
        return new ResponseEntity<>(report, HttpStatus.OK); // 200 OK
    }
}
