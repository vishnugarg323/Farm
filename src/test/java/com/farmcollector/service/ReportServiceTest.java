package com.farmcollector.service;

import com.farmcollector.repository.HarvestDataRepository;
import com.farmcollector.repository.PlantingDataRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ReportServiceTest {

    @Mock
    private PlantingDataRepository plantingDataRepository;

    @Mock
    private HarvestDataRepository harvestedDataRepository;

    @InjectMocks
    private ReportService reportService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGenerateFarmReport() {
        String report = reportService.generateFarmReport(100L);
        assertNotNull(report);
    }
}
