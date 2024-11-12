package com.farmcollector.controller;

import com.farmcollector.model.CropData;
import com.farmcollector.service.PlantingService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;


@SpringBootTest
public class PlantingControllerTest {

    @Mock
    private PlantingService plantingService;

    @InjectMocks
    private PlantingController plantingController;

    @Test
    public void testAddPlantingData() {
        CropData cropData = new CropData();
        cropData.setFarmName("MyFarm");
        cropData.setCropType("Corn");
        cropData.setPlantingArea(10);
        cropData.setExpectedProduct(50);

        when(plantingService.savePlantingData(cropData)).thenReturn("Planting data saved");

        String response = plantingController.addPlantingData(cropData);
        assertThat(response).isEqualTo("Planting data saved");
    }
}
