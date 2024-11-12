package com.farmcollector.controller;

import com.farmcollector.service.ReportService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
public class ReportControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ReportService reportService;

    @InjectMocks
    private ReportController reportController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(reportController).build();
    }

    @Test
    void testGenerateReport() throws Exception {
        String report = "Crop: Corn\nPlanted: 200 tons\nHarvested: 180 tons\n\n";

        when(reportService.generateFarmReport(100L)).thenReturn(report);

        mockMvc.perform(get("/api/farm/100/report"))
                .andExpect(status().isOk())
                .andExpect(content().string(report));

        verify(reportService, times(1)).generateFarmReport(100L);
    }
}
