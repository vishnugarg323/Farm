package com.farmcollector.controller;

import com.farmcollector.model.HarvestData;
import com.farmcollector.service.HarvestService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class HarvestControllerTest {

    @Mock
    private HarvestService harvestService;

    @InjectMocks
    private HarvestController harvestController;

    @Test
    public void testAddHarvestData() {
        HarvestData harvestData = new HarvestData();
        harvestData.setFarmName("MyFarm");
        harvestData.setCropType("Corn");
        harvestData.setHarvestedProduct(45);

        when(harvestService.saveHarvestData(harvestData)).thenReturn("Harvest data saved");

        String response = harvestController.addHarvestData(harvestData);
        assertThat(response).isEqualTo("Harvest data saved");
    }
}
