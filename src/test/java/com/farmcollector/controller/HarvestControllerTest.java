package com.farmcollector.controller;

import com.farmcollector.model.HarvestData;
import com.farmcollector.service.HarvestService;
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
public class HarvestControllerTest {

    private MockMvc mockMvc;

    @Mock
    private HarvestService harvestService;

    @InjectMocks
    private HarvestController harvestController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(harvestController).build();
    }

    @Test
    void testGetHarvestedData() throws Exception {
        HarvestData harvestData = new HarvestData();
        harvestData.setId(1L);
        harvestData.setFarmId(100L);
        harvestData.setCropType("Corn");
        harvestData.setActualAmount(180);

        when(harvestService.getHarvestedData(100L)).thenReturn(List.of(harvestData));

        mockMvc.perform(get("/api/farm/100/harvested"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].cropType").value("Corn"))
                .andExpect(jsonPath("$[0].actualAmount").value(180));

        verify(harvestService, times(1)).getHarvestedData(100L);
    }

    @Test
    public void testCreateHarvestedData() throws Exception {
        HarvestData harvestData = new HarvestData();
        harvestData.setFarmId(1L);
        harvestData.setCropType("Corn");
        harvestData.setActualAmount(45);

        // Mock the service call
        when(harvestService.createHarvestedData(eq(1L), any(HarvestData.class))).thenReturn(harvestData);

        // Perform the POST request and check the status code and response body
        mockMvc.perform(post("/api/farm/1/harvested")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"farmId\": 1, \"cropType\": \"Corn\", \"actualAmount\": 45}"))
                .andExpect(status().isCreated()) // Expect 201 Created
                .andExpect(jsonPath("$.cropType").value("Corn"))
                .andExpect(jsonPath("$.actualAmount").value(45));
    }

    @Test
    public void testCreateHarvestedDataBadRequest() throws Exception {
        // Test for invalid data, expecting a 400 Bad Request status
        mockMvc.perform(post("/api/farm/1/harvested")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"farmId\": 1, \"cropType\": \"\", \"actualAmount\": 0}"))
                .andExpect(status().isBadRequest()); // Expect 400 Bad Request
    }
}
