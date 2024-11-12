package com.farmcollector.controller;

import com.farmcollector.model.PlantingData;
import com.farmcollector.service.PlantingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
public class PlantingControllerTest {

    private MockMvc mockMvc;

    @Mock
    private PlantingService plantingService;

    @InjectMocks
    private PlantingController plantingController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(plantingController).build();
    }

    @Test
    void testGetPlantingData() throws Exception {
        PlantingData plantingData = new PlantingData();
        plantingData.setId(1L);
        plantingData.setFarmId(100L);
        plantingData.setCropType("Corn");
        plantingData.setAreaPlanted(50);
        plantingData.setExpectedAmount(200);

        when(plantingService.getPlantingData(100L)).thenReturn(List.of(plantingData));

        mockMvc.perform(get("/api/farm/100/planting"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].cropType").value("Corn"))
                .andExpect(jsonPath("$[0].expectedAmount").value(200));

        verify(plantingService, times(1)).getPlantingData(100L);
    }

    @Test
    public void testCreatePlantingData() throws Exception {
        PlantingData plantingData = new PlantingData();
        plantingData.setFarmId(1L);
        plantingData.setCropType("Corn");
        plantingData.setAreaPlanted(10);
        plantingData.setExpectedAmount(50);

        // Mock the service call
        when(plantingService.createPlantingData(eq(1L), any(PlantingData.class))).thenReturn(plantingData);

        // Perform the POST request and check the status code and response body
        mockMvc.perform(post("/api/farm/1/planting")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"farmId\": 1, \"cropType\": \"Corn\", \"areaPlanted\": 10, \"expectedAmount\": 50}"))
                .andExpect(status().isCreated()) // Expect 201 Created
                .andExpect(jsonPath("$.cropType").value("Corn"))
                .andExpect(jsonPath("$.areaPlanted").value(10))
                .andExpect(jsonPath("$.expectedAmount").value(50));
    }

    @Test
    public void testCreatePlantingDataBadRequest() throws Exception {
        // Test for invalid data, expecting a 400 Bad Request status
        mockMvc.perform(post("/api/farm/1/planting")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"farmId\": 1, \"cropType\": \"\", \"areaPlanted\": 0, \"expectedAmount\": -1}"))
                .andExpect(status().isBadRequest()); // Expect 400 Bad Request
    }
}
