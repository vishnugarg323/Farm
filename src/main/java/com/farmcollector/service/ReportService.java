package com.farmcollector.service;

import org.springframework.stereotype.Service;

@Service
public class ReportService {

    /**
     * Simulates get report data
     * @return Confirmation message
     */
    public String getReport() {
        // Save planting data logic (could be in database or in-memory)
        return "You have successfully obtained the report";
    }
}
