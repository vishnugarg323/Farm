package com.farmcollector.service;

import com.farmcollector.model.PlantingData;
import com.farmcollector.repository.PlantingDataRepository;
import com.farmcollector.service.PlantingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class PlantingServiceTest {
    @Mock
    private PlantingDataRepository plantingDataRepository;

    @InjectMocks
    private PlantingService plantingService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreatePlantingData() {
        PlantingData plantingData = new PlantingData();
        plantingData.setFarmId(100L);
        plantingData.setCropType("Corn");
        plantingData.setAreaPlanted(50);
        plantingData.setExpectedAmount(200);

        when(plantingDataRepository.save(any(PlantingData.class))).thenReturn(plantingData);

        PlantingData result = plantingService.createPlantingData(100L, plantingData);
        assertNotNull(result);
        assertEquals("Corn", result.getCropType());
        assertEquals(200, result.getExpectedAmount());
    }

}
